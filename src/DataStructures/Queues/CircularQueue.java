package DataStructures.Queues;

import java.lang.reflect.Array;

/**
 * Circular Queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle
 * and the last position is connected back to the first position to make a circle. It is also called 'Ring Buffer'.
 * A circular queue permits better memory utilization than a simple queue when the queue has a fixed size.
 * In a normal Queue, we can insert elements until queue becomes full.
 * It’s used to switch on and off the lights of the traffic signal systems.
 * Apart from that, it can be also used in place of a simple queue in all the applications mentioned in Array queue.
 * @param <T> type of element that will be stored in the Circular queue.
 */
public class CircularQueue<T> implements Queue<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private int front;
    private int rear;
    private final int capacity;
    private final T[] queue;

    public CircularQueue(){
        this(DEFAULT_CAPACITY); // default capacity
    }
    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity){
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        queue = (T[])Array.newInstance(Object[].class.getComponentType() , this.capacity);
    }
    /**
     * Inserts an element at the rear of the queue
     * Throws: IllegalStateException - if the element cannot be added at this time due to capacity restrictions
     * @param value element to be added.
     */
    @Override
    public void enqueue (T value) {
        if (isFull())
            throw new IllegalStateException("Queue is full");
        else if (isEmpty())
            front = rear = 0;
        else
            rear = (rear + 1) % capacity;
        queue[rear] = value;
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
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % capacity;
        return value;
    }

    /**
     * Checks what's at the front of the queue
     * @return element at the front of the queue without removing it
     */
    @Override
    public T peek () {
        return queue[front];
    }

    /**
     * Returns the number of elements in the queue
     * @return number of elements in the queue
     */
    @Override
    public int size () {
        return isEmpty() ? (rear - front) : (rear - front) + 1;
    }

    /**
     * Returns true if the queue is empty
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty () {
        return front == -1 && rear == -1;
    }

    /**
     * Returns true if the queue is full
     * @return true if the queue is full otherwise false
     */
    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = front; ;  i = ++i % capacity) {
            str.append(queue[i]).append(", ");
            if (i == rear)
                break;
        }
        str.delete(str.length() -2 , str.length());
        str.append("]");
        return str.toString();
    }
}
