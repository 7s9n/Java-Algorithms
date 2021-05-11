package DataStructures.Stack;

import java.util.*;
import java.util.function.Consumer;

// An implementation of a Stack using a Linked List

public class StackOfLinkedList {
    public static void main (String[] args) {
        MyStack<Integer> stk = new MyStack<>();
        stk.addAll(1 , 2 ,3);
        for (int num : stk){
            System.out.println(num);
        }
    }
}
/**
 * A class which implements a stack using a linked list
 *
 * <p>Contains all the stack methods : push, pop, printStack, isEmpty
 */
class MyStack<T> implements Iterable<T> {
    private class ListNode<T>{
        private T val;
        private ListNode<T> next;

        public ListNode (T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }
    private ListNode<T> head;

    /**
     * init variable.
     */
    public MyStack(){
        this.head = null;
    }

    /**
     * Add element at top
     *
     * @param val to be added
     * @return void.
     */
    public void add(T val){
        this.head = new MyStack<T>.ListNode<>(val ,this.head);
    }

    /**
     * Pop element at top of stack
     *
     * @return void
     * @throws NoSuchElementException if stack is empty
     */
    public void pop(){
        if (this.empty()){
            throw new NoSuchElementException("Stack is empty.");
        }
        ListNode<T> oldHead = this.head;
        this.head = this.head.next;
        oldHead = null; // clear to let GC do it's work.
    }

    /**
     * Add elements at top
     * @param values
     */
    public void addAll(T... values){
        for (T value : values){
            this.add(value);
        }
    }

    /**
     * get element at the top of the stack
     * @return top of stack.
     */
    public T top() {
        if (this.empty()){
            throw new NoSuchElementException("Your stack is empty.");
        }
        return this.head.val;
    }

    /**
     * check if stack is empty.
     * @return true if stack is empty otherwise false.
     */
    public boolean empty(){
        return this.head == null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator () {
        return new StackIterator<>(this.head);
    }

    class StackIterator<T> implements Iterator<T>{
        private ListNode<T> current;

        public StackIterator(ListNode head){
            current = head;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext () {
            return current != null ? true : false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next () {
            if (current == null){
                throw new NoSuchElementException("Null");
            }
            T val = current.val;
            current = current.next;
            return val;
        }
        @Override
        public void forEachRemaining(Consumer<? super T> action){
            Objects.requireNonNull(action);
            while (hasNext()){
                action.accept(next());
            }
        }
    }
}