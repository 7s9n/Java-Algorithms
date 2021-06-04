package DataStructures.Queues;

public interface Queue<T> {
    /**
     * Inserts an element at the rear of the queue.
     *
     * {@code Throws} IllegalStateException -
     * if the element cannot be added at this time due to capacity restrictions
     * @param value element to be added.
     */
    void enqueue(T value);
    /**
     * Remove an element from the front of the queue
     * @return the element that has been removed from the front
     */
    T dequeue();
    /**
     * Checks what's at the front of the queue
     * @return element at the front of the queue without removing it
     */
    T peek();
    /**
     * Returns the number of elements in the queue
     * @return number of elements in the queue
     */
    int size();
    /**
     * Returns true if the queue is empty
     * @return true if the queue is empty
     */
    boolean isEmpty();
}
