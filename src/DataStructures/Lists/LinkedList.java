package DataStructures.Lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface LinkedList<T> extends Iterable<T>{
    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    Iterator<T> iterator();

    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param value element to be added
     * @return true if the element was added successfully .
     */
    boolean add(T value);

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param value the element to add
     * @return true if the element was added successfully .
     */
    boolean addFirst(T value);

    /**
     * Inserts the specified element at the end of this list.
     *
     * @param value the element to add
     * @return true if the element was added successfully .
     */
    boolean addLast(T value);

    /**
     * Add an element at a specified index
     * @param idx index that element will be added at
     * @param value the element to add
     * @return true if the element was added successfully .
     */
    boolean addAt(int idx , T value);

    /**
     * Return the value of the first node in the list.
     * @throws NoSuchElementException if this list is empty
     * @return the first node if it exists, O(1)
     */
    T getFirst();

    /**
     * Return the value of the last node in the list.
     * @throws NoSuchElementException if this list is empty
     * @return the last node if it exists, O(1)
     */
    T getLast();

    T getAt(int index);


    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or {@code null} if this list is empty
     */
    T removeFirst();

    /**
     * Retrieves and removes the tail (last element) of this list.
     *
     * @return the tail of this list, or {@code null} if this list is empty
     */
    T removeLast();

    /**
     * Remove a node at a particular index
     * @throws IllegalArgumentException if the index is not exist in the list or index is less than 0
     * @return element at the specified index.
     */
    T removeAt(int index);

    /**
     * Find the index of a particular value in the linked list
     * @return index of a particular value or -1 if value doesn't exist in the list.
     */
    int indexOf();

    /**
     * Returns {@code true} if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element {o}.
     */
    boolean contains(Object o);
}
