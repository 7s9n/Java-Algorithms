package DataStructures.Queues;

import DataStructures.Lists.DoublyLinkedList;

public class ListDeque<T> implements Deque<T> {
    ListNode<T> front;
    ListNode<T> rear;
    int size;


    ListDeque(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Inserts an element at the rear of the queue.
     * <p>
     * {@code Throws} IllegalStateException -
     * if the element cannot be added at this time due to capacity restrictions
     *
     * @param value element to be added.
     */
    @Override
    public void enqueue (T value) {
        addRear(value);
    }

    /**
     * Remove an element from the front of the queue
     *
     * @return the element that has been removed from the front
     */
    @Override
    public T dequeue () {
        return removeFront();
    }

    /**
     * Checks what's at the front of the queue
     *
     * @return element at the front of the queue without removing it
     */
    @Override
    public T peek () {
        return peekFront();
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return number of elements in the queue
     */
    @Override
    public int size () {
        return size;
    }

    /**
     * Returns true if the queue is empty
     *
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty () {
        return size() == 0;
    }

    @Override
    public void addFront (T data) {
        linkFront(data);
    }

    @Override
    public void addRear (T data) {
        linkRear(data);
    }

    @Override
    public T removeFront () {
        if (front == null)
            return null;
        return unlinkFront(front);
    }

    @Override
    public T removeRear () {
        if (rear == null)
            return null;
        return unlinkRear(rear);
    }

    @Override
    public T peekFront () {
        return isEmpty() ? null : front.data;
    }

    @Override
    public T peekRear () {
        return isEmpty() ? null : rear.data;
    }
    @Override
    public void clear () {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabi
        for (ListNode<T> i = front; i != null;) {
            ListNode<T> next = i.next;
            i.data = null;
            i.next = null;
            i.prev = null;
            i = next;
        }
        front = rear = null;
        size = 0;
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
    } // end of class ListNode<T> .

    private void linkFront(T data){
        ListNode<T> f = front;
        ListNode<T> newNode = new ListNode<>(null , data , f);
        front = newNode;
        if (f == null)
            rear = newNode;
        else
            f.prev = newNode;
        ++size;
    }
    private void linkRear(T data){
        ListNode<T> r = rear;
        ListNode<T> newNode = new ListNode<>(r , data , null);
        rear = newNode;
        if (r == null)
            front = newNode;
        else
            r.next = newNode;
        ++size;
    }
    private T unlinkFront(ListNode<T> f){
        T data = f.data;
        ListNode<T> next = f.next;
        f.data = null;
        f.next = null; // help GC
        front = next;
        if (next == null)
            rear = null;
        else
            next.prev = null;
        --size;
        return data;
    }
    private T unlinkRear(ListNode<T> r){
        T data = r.data;
        ListNode<T> prev = r.prev;
        r.data = null;
        r.next = null; // help GC
        rear = prev;
        if (prev == null)
            front = null;
        else
            prev.next = rear;
        --size;
        return data;
    }
}
