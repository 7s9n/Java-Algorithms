package DataStructures.Queues;

import java.lang.reflect.Array;

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
    @Override
    public void enqueue (T value) {
        if (isFull())
            throw new RuntimeException("Queue is full");
        else if (isEmpty())
            front = rear = 0;
        else
            rear = (rear + 1) % capacity;
        queue[rear] = value;
    }

    @Override
    public T dequeue () {
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

    @Override
    public T peek () {
        return queue[front];
    }

    @Override
    public int size () {
        return isEmpty() ? (rear - front) : (rear - front) + 1;
    }

    @Override
    public boolean isEmpty () {
        return front == -1 && rear == -1;
    }

    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }
}
