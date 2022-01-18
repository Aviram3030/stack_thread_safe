package experis.ds.tests;

import experis.ds.BlockingStack;
import experis.ds.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Consumer implements Runnable {
    private final Stack<Box> stack;
    private final List<Box> products = new ArrayList<>();

    public Consumer(Stack<Box> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        var box = stack.pop();
        while(box.getType() != -1){
            products.add(box);
        }

        stack.push(box);
    }

    public List<Box> getProducts() {
        return products;
    }
}
