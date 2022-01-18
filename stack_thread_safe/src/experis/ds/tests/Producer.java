package experis.ds.tests;

import experis.ds.Stack;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable{
    private final Stack<Box> stack;
    private final List<Box> products;

    public Producer(Stack<Box> stack, List<Box> products) {
        this.stack = stack;
        this.products = products;
    }

    @Override
    public void run() {
        for (Box product : products) {
            stack.push(product);
        }
    }
}
