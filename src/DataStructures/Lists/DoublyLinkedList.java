package DataStructures.Lists;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements LinkedList<T>{
    private int size;
    private ListNode<T> head;
    private ListNode<T> tail;


    public DoublyLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     * @return the number of elements in this list
     */
    @Override
    public int size () {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty () {
        return size() == 0;
    }

    /**
     * Appends the specified element to the end of this list (optional operation).
     *
     * @param value element to be added
     * @return true if the element was added successfully .
     */
    @Override
    public boolean add (T value) {
        return addLast(value);
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param value the element to add
     * @return true if the element was added successfully .
     */
    @Override
    public boolean addFirst (T value) {
        linkHead(value);
        return true;
    }

    /**
     * Inserts the specified element at the end of this list.
     *
     * @param value the element to add
     * @return true if the element was added successfully .
     */
    @Override
    public boolean addLast (T value) {
        linkTail(value);
        return true;
    }

    /**
     * Add an element at a specified index
     *
     * @param idx   index that element will be added at
     * @param value the element to add
     * @return true if the element was added successfully .
     */
    @Override
    public boolean addAt (int idx, T value) {
        return false;
    }

    /**
     * Return the value of the first node in the list.
     *
     * @return the first node if it exists, O(1)
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public T getFirst () {
        if (head == null)
            throw new NoSuchElementException();
        return head.data;
    }

    /**
     * Return the value of the last node in the list.
     *
     * @return the last node if it exists, O(1)
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public T getLast () {
        if (tail == null)
            throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public T getAt (int index) {
        if (!isValidElementIndex(index))
            throw new IndexOutOfBoundsException(indexErrorMessage(index));
        ListNode<T> cur = index < (size / 2) ? head : tail;

        if (cur == head)
            for (int i = 0; i < index ; ++i)
                cur = cur.next;
        else
            for (int i = size -1 ; i > index ; --i)
                cur = cur.prev;
        return cur.data;
    }

    @Override
    public T removeFirst () {
        if (head == null)
            throw new NoSuchElementException();
        return unlinkHead(head);
    }

    @Override
    public T removeLast () {
        if (tail == null)
            throw new NoSuchElementException();
        return unlinkTail(tail);
    }

    /**
     * Remove a node at a particular index
     *
     * @param index
     * @return element at the specified index.
     * @throws IllegalArgumentException if the index is not exist in the list or index is less than 0
     */
    @Override
    public T removeAt (int index) {
        return null;
    }

    /**
     * Find the index of a particular value in the linked list
     *
     * @return index of a particular value or -1 if value doesn't exist in the list.
     */
    @Override
    public int indexOf () {
        return 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element {o}.
     */
    @Override
    public boolean contains (Object o) {
        return false;
    }

    private void incrementSize(){
        ++size;
    }
    private void decrementSize(){
        --size;
    }
    private boolean isValidElementIndex(int index){
        return index >= 0 && index < size;
    }
    private String indexErrorMessage(int index){
        return "Index: " + index + ", Size: " + size;
    }
    private static class ListNode<T>{
        T data;
        ListNode<T> next;
        ListNode<T> prev;

        ListNode(ListNode<T> prev , T data , ListNode<T> next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    } // end of ListNode class

    /**
     * Links data as head element.
     */
    private void linkHead(T data){
        ListNode<T> h = head;
        ListNode<T> newListNode = new ListNode<>(null , data , h);
        head = newListNode;
        if (h == null)
            tail = newListNode;
        else
            h.prev = newListNode;
        incrementSize();
    }

    /**
     * Links data as tail element.
     */
    private void linkTail(T data){
        ListNode<T> t = tail;
        ListNode<T> newListNode = new ListNode<>(t , data , null);
        tail = newListNode;
        if (t == null)
            head = newListNode;
        else
            t.next = newListNode;
        incrementSize();
    }
    /**
     * Unlinks non-null first node f.
     */
    private T unlinkHead(ListNode<T> f){
        T data = f.data;
        ListNode<T> next = f.next;
        f.data = null;
        f.next = null; // help GC
        head = next;
        if (next == null)
            tail = null;
        else
            next.prev = null; // new head node previous is null.
        decrementSize();
        return data;
    }
    /**
     * Unlinks non-null tail node t.
     */
    private T unlinkTail(ListNode<T> t){
        T data = t.data;
        ListNode<T> prev = t.prev;
        t.data = null;
        t.prev = null; // help GC
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.next = tail;
        decrementSize();
        return data;
    }
    private class ListItr implements Iterator<T>{
        private ListNode<T> cur;
        public ListItr(){
            cur = head;
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
            return cur != null;
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
            T data = cur.data;
            cur = cur.next;
            return data;
        }
    }
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<T> iterator () {
        return new ListItr();
    }

    public static void main (String[] args) {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            integers.addFirst(i +1);
        }
        for (int i : integers)
            System.out.println(i);
        System.out.println("Get at: " + integers.getAt(999));
    }
}
