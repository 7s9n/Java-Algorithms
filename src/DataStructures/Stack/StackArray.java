package DataStructures.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

class StackArray<T> implements Stack<T> {
    private Object[] container;
    private int size;
    private int capacity;

    public StackArray(){
        this(10);
    }
    public StackArray(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.container =  new Object[capacity];
    }
    @Override
    public int size () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return size == 0;
    }

    @Override
    public void push (T val) {
        if (size == capacity){
            this.increaseCapacity();
        }
        container[size++] = val;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T pop (){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T val = (T)container[--size];
        container[size] = null;
        return val;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T peek () {
        if (isEmpty())
            throw new EmptyStackException();
        return (T)container[size - 1];
    }
    private void increaseCapacity() {
        capacity *= 2;
        container = Arrays.copyOf(container, capacity);
    }
}
