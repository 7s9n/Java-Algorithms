package DataStructures.Queues;

interface Deque<T> extends Queue<T>{
    void addFront(T data);
    void addRear(T data);
    T removeFront();
    T removeRear();
    T peekFront();
    T peekRear();
    void clear();
}
