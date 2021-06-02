package DataStructures.Queues;

import java.lang.reflect.Array;

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

    @Override
    public void enqueue (T value) {
        if (isFull())
            throw new RuntimeException("Queue is full.");
        else
            queue[++rear] = value;
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
        if (front == rear){
            front = 0;
            rear = -1;
        }
        else
            ++front;

        return value;
    }
    // return but not remove the front element in the queue.
    @Override
    public T peek () {
        if (isEmpty())
            throw new RuntimeException("Queue is empty.");

        return queue[front];
    }
    // elements are added in the rear.
    @Override
    public int size () {
        return (rear - front) + 1;
    }
    // check if the queue is empty or not.
    @Override
    public boolean isEmpty () {
        return size() == 0;
    }
    // check if the queue is full or not
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
