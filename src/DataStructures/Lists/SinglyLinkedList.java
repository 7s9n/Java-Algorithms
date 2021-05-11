package DataStructures.Lists;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SinglyLinkedList<T> implements Iterable<T>{
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator () {
        return new SinglyListIterator(head);
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach (Consumer<? super T> action) {
        for (T t : this){
            action.accept(t);
        }
    }

    private class ListNode<T>{
        T val;
        ListNode<T> next;
        ListNode(T val , ListNode<T> next){
            this.val = val;
            this.next = next;
        }
    }
    private class SinglyListIterator<T> implements Iterator<T>{
        private ListNode<T> current;
        public SinglyListIterator(ListNode<T> ptr){
            this.current = ptr;
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
            return this.current != null ? true : false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next () {
            if (!hasNext()){
                throw new NoSuchElementException("List is empty");
            }
            T val = current.val;
            current = current.next;
            return val;
        }
    }
    public SinglyLinkedList(){
        this.head = null;
        size = 0;
    }
    public boolean empty(){
        return head == null ? true : false;
    }
    public void addAtHead(T val){
        if (empty())
            head = tail = new ListNode<>(val , null);
        else
            this.head = new ListNode<>(val , head);
        ++size;
    }
    public void addLast(T val){
        if (empty())
            this.addAtHead(val);
        else{
            this.tail.next = new ListNode<>(val , null);
            tail = tail.next;
            ++size;
        }
    }
    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }
    public T getNth(int pos){
        checkBounds(pos , 1 , size);
        ListNode<T> tmp = this.head;
        for (int i = 0; i < pos - 1; i++) {
            tmp = tmp.next;
        }
        return tmp.val;
    }
    public static void main (String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAtHead(1);
        list.addLast(2);
        list.addLast(3);
        list.forEach((n)->{
            System.out.print(n + "->");
        });
    }
}
