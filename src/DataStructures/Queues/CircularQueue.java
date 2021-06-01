package DataStructures.Queues;

import java.lang.reflect.Array;

public class CircularQueue<T> implements Queue<T>{
    private int front;
    private int rear;
    private int capacity;
    private T[] queue;

    public CircularQueue(int capacity){
        this.front = this.rear = -1;
        this.capacity = capacity;
        queue = (T[])Array.newInstance(Object[].class.getComponentType() , this.capacity);
    }
    @Override
    public void enqueue (T value) {

    }

    @Override
    public T dequeue () {
        return null;
    }

    @Override
    public T peek () {
        return null;
    }

    @Override
    public int size () {
        return 0;
    }

    @Override
    public boolean isEmpty () {
        return front == -1 && rear == -1;
    }

    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }
}
