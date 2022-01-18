package experis.ds;

import java.util.concurrent.locks.*;

public class BlockingStack<T> implements Stack<T>{
    private final T[] stack;
    private int size = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Condition full = lock.writeLock().newCondition();
    private final Condition empty = lock.writeLock().newCondition();

    public BlockingStack(int capacity) {
        stack = (T[])new Object[capacity];
    }

    @Override
    public void push(T val) {
        lock.writeLock().lock();
        while(isFull()){
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stack[size++] = val;
        lock.writeLock().unlock();
    }

    @Override
    public T pop() {
        lock.writeLock().lock();
        while(isEmpty()){
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            return stack[--size];
        }
        finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public T peek() {
        lock.readLock().lock();
        if(!isEmpty()){
            return stack[size - 1];
        }
        lock.readLock().unlock();
        return null;
    }
    
    private boolean isEmpty(){
        return size == 0;
    }
    
    private boolean isFull(){
        return size == stack.length;
    }
}
