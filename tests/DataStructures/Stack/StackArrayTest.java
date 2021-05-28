package DataStructures.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class StackArrayTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp () {
        stack = new StackArray<>();
    }
    @Test
    void testEmptyStack(){
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0 , stack.size());
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
    }
    @Test
    public void testPopOnEmpty(){
        Assertions.assertThrows(EmptyStackException.class , () -> stack.pop());
    }
    @Test
    public void testPush(){
        for (int i = 1; i <= 100; i++){
            stack.push(i);
            Assertions.assertEquals(i,stack.size());
        }
    }
    @Test
    public void testPop(){
        int i = 1;
        for (; i <= 1000; ++i){
            stack.push(i);
        }
        for (--i; i>= 1; --i){
            Assertions.assertEquals(i,stack.size());
            Assertions.assertEquals(i,stack.pop());
            Assertions.assertEquals(i-1,stack.size());
        }
    }
    @Test
    public void testPeek(){
        Assertions.assertEquals(0,stack.size());
        stack.push(8);
        Assertions.assertEquals(8,stack.peek());
        Assertions.assertEquals(1,stack.size());
    }
    @Test
    public void testIterator(){
        int i;
        for (i = 1; i <= 1000; ++i)
            stack.push(i);

        for (var num : stack){
            Assertions.assertEquals(num , stack.peek());
            Assertions.assertEquals(--i , stack.pop());
        }
    }
}