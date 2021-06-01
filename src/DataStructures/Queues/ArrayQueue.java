package DataStructures.Queues;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private int front; // elements are removed or peeked from the front.
    private int rear; // elements are added in the rear.
    private int count; // elements are added in the rear.
    private int capacity; // capacity of the queue (this is doubled when is exceeded).
    private T[] queue; // the array that sits behind the queue.

    @SuppressWarnings("unchecked")
    public ArrayQueue(){
        // we use Java Reflection since Java doesn't allow us to instantiate a generic array
        queue = (T[]) Array.newInstance(Object[].class.getComponentType(),DEFAULT_CAPACITY);
        count = 0; // initially, the size of the queue is 0.
        front = 0; // the index of the first element is 0.
        rear =-1; // initially, there is no element in the queue.
        capacity = DEFAULT_CAPACITY; // initially, the capacity is of 10 elements
    }

    @Override
    public void enqueue (T value) {
        if (isFull())
            increaseCapacity();

        rear = (rear + 1) % capacity;

        System.out.println("Rear: " + rear);

        queue[rear] = value;

        ++count;
    }
    // remove and return the front element from the queue.
    @Override
    public T dequeue () {
        // if the queue is empty we just throw a meaningful exception
        if (isEmpty())
            throw new RuntimeException("Queue is empty.");

        // extract the element from the front
        T value = queue[front];
        queue[front] = null;

        // set the new front
        front = (front + 1) % capacity;

        // decrease the size of the queue
        --count;

        return value;
    }
    // return but not remove the front element in the queue.
    @Override
    public T peek () {
        if (isEmpty())
            throw new RuntimeException("Queue is empty.");

        return queue[front];
    }

    @Override
    public int size () {
        return this.count;
    }
    // check if the queue is empty or not.
    @Override
    public boolean isEmpty () {
        return size() == 0;
    }
    // check if the queue is full or not
    public boolean isFull(){
        return size() == capacity;
    }
    private void  increaseCapacity(){
        int newCapacity = queue.length * 2;
        queue = Arrays.copyOf(queue , newCapacity);
        capacity = newCapacity; // setting the new capacity
    }
}
