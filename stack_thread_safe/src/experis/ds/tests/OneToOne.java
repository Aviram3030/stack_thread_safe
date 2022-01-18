package experis.ds.tests;

import experis.ds.BlockingStack;
import experis.ds.Stack;

import static org.junit.jupiter.api.Assertions.*;

class OneToOne {

    Stack<Integer> stack = new BlockingStack<>(5);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }
}