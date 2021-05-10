package DataStructures.Stack;

import java.util.*;
import java.util.function.Consumer;

class Person {
    private final int id;
    private final String name;

    public Person (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }
}
public class StackOfLinkedList {
    public static void main (String[] args) {
        MyStack<Person> stk = new MyStack<>();
        stk.addAll(
                new Person(1 , "Hussein Sarea") ,
                new Person(2 , "Moataz Sarea") ,
                new Person(3, "Ekram Sarea")
        );

        stk.pop();

        var it = stk.iterator(); // Iterator<Person>
        it.forEachRemaining(person -> {
            System.out.println(person.getId());
            System.out.println(person.getName());
        });

    }
}
class MyStack<T> implements Iterable<T> {
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator () {
        return new StackIterator<>(this.head);
    }
    private class ListNode<T>{
        private T val;
        private ListNode<T> next;

        public ListNode (T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }
    private ListNode<T> head;

    public MyStack(){
        this.head = null;
    }

    public void add(T val){
        this.head = new MyStack<T>.ListNode<>(val ,this.head);
    }
    public void pop(){
        if (this.empty()){
            throw new NoSuchElementException("Stack is empty.");
        }
        ListNode<T> oldHead = this.head;
        this.head = this.head.next;
        oldHead = null;
    }
    public void addAll(T... values){
        for (T value : values){
            this.add(value);
        }
    }
    public T top() {
        if (this.empty()){
            throw new NoSuchElementException("Your stack is empty.");
        }
        return this.head.val;
    }
    public boolean empty(){
        return this.head == null;
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