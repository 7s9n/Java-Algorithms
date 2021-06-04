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

    @Override
    public int size () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return size() == 0;
    }

    @Override
    public boolean add (T value) {
        return addLast(value);
    }

    @Override
    public boolean addFirst (T value) {
        linkHead(value);
        return true;
    }
    @Override
    public boolean addLast (T value) {
        linkTail(value);
        return true;
    }

    @Override
    public boolean addBefore (T data, T target) {
        linkBefore(data , getNode(indexOf(target)));
        return true;
    }

    @Override
    public boolean addAfter (T data, T target) {
        linkAfter(data , getNode(indexOf(target)));
        return true;
    }

    @Override
    public boolean add (int idx, T data) {
        checkPositionIndex(idx);
        if (idx == 0)
            linkHead(data);
        else if (idx == size)
            linkTail(data);
        else {
            linkBefore(data , getNode(idx));
        }
        return true;
    }

    @Override
    public T getFirst () {
        if (head == null)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T getLast () {
        if (tail == null)
            throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public T getAt (int index) {
        checkElementIndex(index);

        return getNode(index).data;
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

    @Override
    public T removeAt (int index) {
        checkElementIndex(index);

        if (index == 0)
            return unlinkHead(head);
        else if (index == size)
            return unlinkTail(tail);
        else
            return unlinkMiddle(getNode(index));
    }


    @Override
    public int indexOf (Object o) {
        int index = 0;
        if (o == null){
            for (ListNode<T> i = head; i != null; i = i.next){
                if (i.data == null)
                    return index;
                ++index;
            }
        }else{
            for (ListNode<T> i = head; i != null; i = i.next){
                if (o.equals(i.data))
                    return index;
                ++index;
            }
        }
        return -1;
    }

    @Override
    public boolean contains (Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void clear () {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabi
        for (ListNode<T> i = head; i != null;) {
            ListNode<T> next = i.next;
            i.data = null;
            i.next = null;
            i.prev = null;
            i = next;
        }
        head = tail = null;
        size = 0;
    }

    private void incrementSize(){
        ++size;
    }
    private void decrementSize(){
        --size;
    }
    private void checkElementIndex(int index){
        if (!isValidElementIndex(index))
            throw new IndexOutOfBoundsException(indexErrorMessage(index));
    }
    private void checkPositionIndex(int index){
        if (!isValidPositionIndex(index))
            throw new IndexOutOfBoundsException(indexErrorMessage(index));
    }
    private boolean isValidElementIndex(int index){
        return index >= 0 && index < size;
    }
    private boolean isValidPositionIndex(int index){
        return index >= 0 && index <= size;
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
     * inserts element data before non-null Node node.
     */
    private void linkBefore(T data , ListNode<T> node){
        ListNode<T> prev = node.prev;
        ListNode<T> newNode = new ListNode<>(prev , data , node);
        node.prev = newNode;
        if (prev == null)
            head = newNode;
        else
            prev.next = newNode;
        incrementSize();
    }
    private void linkAfter(T data , ListNode<T> node){
        ListNode<T> next = node.next;
        ListNode<T> newNode = new ListNode<>(node , data , next);
        node.next = newNode;
        if (next == null)
            tail = newNode;
        else
            next.prev = newNode;
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
    /**
     * Unlinks non-null middle node m.
     */
    private T unlinkMiddle(ListNode<T> m){
        T data = m.data;
        ListNode<T> next = m.next;
        ListNode<T> prev = m.prev;

        prev.next = next;
        if (next != null)
            next.prev = null;
        // Memory clean up.
        m.data = null;
        m.next = m.prev = null; // help GC
        decrementSize();
        return data;
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private ListNode<T> getNode(int index){
        ListNode<T> cur = index < (size / 2) ? head : tail;

        if (cur == head){
            for (int i = 0; i < index; ++i)
                cur = cur.next;
        }else{
            for (int j = size - 1; j > index; --j) {
                cur = cur.prev;
            }
        }
        return cur;
    }
    private class ListItr implements Iterator<T>{
        private ListNode<T> cur;
        public ListItr(){
            cur = head;
        }
        @Override
        public boolean hasNext () {
            return cur != null;
        }

        @Override
        public T next () {
            if (!hasNext()){
                throw new NoSuchElementException("List is empty");
            }
            T data = cur.data;
            cur = cur.next;
            return data;
        }
    } // end of ListItr
    @Override
    public Iterator<T> iterator () {
        return new ListItr();
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (T val : this)
            str.append(val).append(", ");
        str.delete(str.length() - 2 , str.length());
        str.append("]");
        return str.toString();
    }
}