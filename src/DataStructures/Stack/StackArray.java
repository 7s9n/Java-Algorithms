package DataStructures.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * This class implements a Stack using a regular array.
 *
 * A stack is exactly what it sounds like. An element gets added to the top of the stack and only
 * the element on the top may be removed. This is an example of an array implementation of a Stack.
 * So an element can only be added/removed from the end of the array. In theory stack have no fixed
 * size, but with an array implementation it does.
 */

class StackArray<T> implements Stack<T> {
    private T[] container;
    private int size;
    private int capacity;
    private class StackArrayIterator implements Iterator<T>{
        int ptr = size;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext () {
            return ptr != 0 ;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next () {
            return container[--ptr];
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove () {
            throw new UnsupportedOperationException("Unsupported");
        }

        /**
         * Performs the given action for each remaining element until all elements
         * have been processed or the action throws an exception.  Actions are
         * performed in the order of iteration, if that order is specified.
         * Exceptions thrown by the action are relayed to the caller.
         * <p>
         * The behavior of an iterator is unspecified if the action modifies the
         * collection in any way (even by calling the {@link #remove remove} method
         * or other mutator methods of {@code Iterator} subtypes),
         * unless an overriding class has specified a concurrent modification policy.
         * <p>
         * Subsequent behavior of an iterator is unspecified if the action throws an
         * exception.
         *
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         * @implSpec <p>The default implementation behaves as if:
         * <pre>{@code
         *     while (hasNext())
         *         action.accept(next());
         * }</pre>
         * @since 1.8
         */
        @Override
        public void forEachRemaining (Consumer<? super T> action) {
            while (hasNext())
                action.accept(next());
        }
    }
    public StackArray(){
        this(10);
    }
    @SuppressWarnings("unchecked")
    public StackArray(int capacity){
        this.size = 0;
        this.capacity = capacity;
        // we use Java Reflection since Java doesn't allow us to instantiate a generic array
        this.container = (T[])Array.newInstance(Object[].class.getComponentType(),capacity);
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
    @Override
    public T pop (){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T val = container[--size];
        container[size] = null;
        return val;
    }
    @Override
    public T peek () {
        if (isEmpty())
            throw new EmptyStackException();
        return container[size - 1];
    }
    private void increaseCapacity() {
        capacity *= 2;
        container = Arrays.copyOf(container, capacity);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator () {
        return new StackArrayIterator();
    }

}