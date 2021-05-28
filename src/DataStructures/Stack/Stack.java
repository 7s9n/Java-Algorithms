package DataStructures.Stack;

import java.util.EmptyStackException;

public interface Stack <T> extends Iterable<T>{
    // return the number of elements in the stack
    int size();

    // return if the stack is empty
    boolean isEmpty();

    // push the element on the stack
    void push(T val);

    // pop the element off the stack
    T pop() throws EmptyStackException;

    // get Top of the stack
    T peek();

}
