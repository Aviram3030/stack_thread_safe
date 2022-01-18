package experis.ds;

public class BlockingStack<T> implements Stack<T>{
    private T[] stack;
    private int size = 0;

    public BlockingStack(int capacity) {
        stack = (T[])new Object[capacity];
    }

    @Override
    public void push(T val) {
        if(!isFull()){
            stack[size++] = val;
        }
    }

    @Override
    public T pop() {
        if(!isEmpty()){
            return stack[--size];
        }

        return null;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            return stack[size - 1];
        }

        return null;
    }
    
    private boolean isEmpty(){
        return size == 0;
    }
    
    private boolean isFull(){
        return size == stack.length;
    }
}
