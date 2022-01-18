package experis.ds;

public class BlockingStack<T> implements Stack<T>{
    private int[] stack;
    private int size = 0;

    public BlockingStack(int capacity) {
        stack = new int[capacity];
    }

    @Override
    public void push(T val) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }
    
    private boolean isEmpty(){
        return size == 0;
    }
    
    private boolean isFull(){
        return size == stack.length;
    }
}
