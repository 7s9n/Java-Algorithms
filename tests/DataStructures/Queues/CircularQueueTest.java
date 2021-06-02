package DataStructures.Queues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CircularQueueTest {
    private CircularQueue<Integer> queue;
    private final int capacity = 100000;
    @BeforeEach
    void setUp(){
        queue = new CircularQueue<>(capacity);
        enqueue();
    }
    void enqueue () {
        Assertions.assertEquals(0 , queue.size());
        for (int i = 1; i <= capacity ; ++i)
            queue.enqueue(i);
        Assertions.assertEquals(capacity , queue.size());
    }

    @Test
    void dequeue () {
        Assertions.assertEquals(1 , queue.dequeue());
        Assertions.assertFalse(queue.isEmpty());
        queue.enqueue(1);
        Assertions.assertTrue(queue.isFull());
    }

    @Test
    void peek () {
        Assertions.assertEquals(capacity , queue.size());
        Assertions.assertEquals(1 , queue.peek());
        Assertions.assertEquals(capacity , queue.size());
    }

    @Test
    void isEmpty () {
        Assertions.assertFalse(queue.isEmpty());
        for (int i = 1; i <= capacity; i++)
            Assertions.assertEquals(i , queue.dequeue());
        Assertions.assertThrows(RuntimeException.class , ()-> queue.dequeue());
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void isFull () {
        Assertions.assertTrue(queue.isFull());
        Assertions.assertThrows(RuntimeException.class , ()-> queue.enqueue(1));
        queue.dequeue();
        Assertions.assertFalse(queue.isFull());
        queue.enqueue(1);
        Assertions.assertTrue(queue.isFull());
    }
}