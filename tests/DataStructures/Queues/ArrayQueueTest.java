package DataStructures.Queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    private ArrayQueue<Integer> queue;
    private final int capacity = 10;
    @BeforeEach
    void setUp () {
        queue = new ArrayQueue<>(capacity);
        enqueue();
    }
    void enqueue () {
        for (int i = 1; i <= capacity ; i++)
            queue.enqueue(i);
    }
    @Test
    void dequeue () {
        for (int i = 1; i <= capacity ; i++)
            assertEquals(i , queue.dequeue());

        assertEquals(0, queue.size());
    }

    @Test
    void peek () {
        for (int i = 1; i <= capacity ; i++) {
            assertEquals(i , queue.peek());
            queue.dequeue();
        }
        assertThrows(RuntimeException.class , queue::dequeue);
    }

    @Test
    void size () {
        assertEquals(capacity,queue.size());
        for (int i = 1; i <= capacity ; i++){
            queue.dequeue();
            assertEquals(capacity - i , queue.size());
        }
        assertEquals(0 , queue.size());
    }

    @Test
    void isEmpty () {
        assertFalse(queue.isEmpty());

        for (int i = 1; i <= capacity ; i++)
            queue.dequeue();

        assertTrue(queue.isEmpty());
    }
    @Test
    void isFull () {
        assertTrue(queue.isFull());
        assertThrows(RuntimeException.class , () -> queue.enqueue(1));
    }
}