package DataStructures.Lists;

import java.util.Iterator;

public interface LinkedList<T> extends Iterable<T>{

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    boolean add(T value);

    boolean add(int idx , T value);

    boolean addFirst(T value);

    boolean addLast(T value);

    boolean addBefore(T data , T target);

    boolean addAfter(T data , T target);

    T getFirst();

    T getLast();

    T getAt(int index);

    T removeFirst();

    T removeLast();

    T removeAt(int index);

    int indexOf(Object o);

    boolean contains(Object o);

    void clear();
}
