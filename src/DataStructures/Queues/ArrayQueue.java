package DataStructures.Queues;

import java.lang.reflect.Array;

/**
 * A simple queue is the most basic queue.
 * In this queue, the enqueue operation takes place at the rear,
 * while the dequeue operation takes place at the front:
 * Its applications are process scheduling, disk scheduling, memory management, IO buffer, pipes, call center phone systems, and interrupt handling.
 * @param <T> type of element that will be stored in the Array queue.
 */
public class ArrayQueue<T> implements Queue<T>{
    private int front; // elements are removed or peeked from the front.
    private int rear; // elements are added in the rear.
    private final int capacity; // capacity of the queue.
    private final T[] queue; // the array that sits behind the queue.

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
        // we use Java Reflection since Java doesn't allow us to instantiate a generic array
        this.queue = (T[]) Array.newInstance(Object[].class.getComponentType(),capacity);
        this.front = 0; // initially , the index of the first element is 0.
        this.rear = -1; // initially, there is no element in the queue.
        this.capacity = capacity; // capacity of the queue.
    }
    /**
     * Inserts an element at the rear of the queue
     * Throws: IllegalStateException - if the element cannot be added at this time due to capacity restrictions
     * @param value element to be added.
     */
    @Override
    public void enqueue (T value) {
        if (isFull())
            throw new RuntimeException("Queue is full.");
        else
            queue[++rear] = value;
    }
    /**
     * Remove an element from the front of the queue
     * @return the element that has been removed from the front
     */
    @Override
    public T dequeue () {
        // if the queue is empty we just throw a meaningful exception
        if (isEmpty())
            throw new RuntimeException("Queue is empty.");

        // extract the element from the front
        T value = queue[front];
        queue[front] = null;

        // set the new front
        if (front == rear){
            front = 0;
            rear = -1;
        }
        else
            ++front;

        return value;
    }
    /**
     * Checks what's at the front of the queue
     * @return element at the front of the queue without removing it
     */
    @Override
    public T peek () {
        if (isEmpty())
            throw new RuntimeException("Queue is empty.");

        return queue[front];
    }
    /**
     * Returns the number of elements in the queue
     * @return number of elements in the queue
     */
    @Override
    public int size () {
        return (rear - front) + 1;
    }
    /**
     * Returns true if the queue is empty
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty () {
        return size() == 0;
    }
    /**
     * Returns true if the queue is full
     * @return true if the queue is full otherwise false
     */
    public boolean isFull(){
        return (rear == capacity - 1);
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = front; i <= rear; i++) {
            str.append(queue[i]);
            if (i < rear)
                str.append(" ,");
        }
        str.append("]");
        return str.toString();
    }
}
