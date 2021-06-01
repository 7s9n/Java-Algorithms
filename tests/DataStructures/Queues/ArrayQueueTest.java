package DataStructures.Queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    private ArrayQueue<Integer> queue;
    @BeforeEach
    void setUp () {
        queue = new ArrayQueue<>();
        for (int i = 1; i <= 1000; i++)
            queue.enqueue(i);
    }
    @Test
    void enqueue () {
        assertEquals(1 , queue.peek());
    }

    @Test
    void dequeue () {
        for (int i = 1; i <= 1000 ; i++)
            assertEquals(i , queue.dequeue());
    }

    @Test
    void peek () {
        for (int i = 1; i <= 1000 ; i++) {
            assertEquals(i , queue.peek());
            queue.dequeue();
        }
        assertThrows(RuntimeException.class , ()-> queue.peek());
    }

    @Test
    void size () {
        assertEquals(1000,queue.size());
        for (int i = 1; i <= 1000 ; i++){
            queue.dequeue();
            assertEquals(1000 - i , queue.size());
        }
        assertEquals(0 , queue.size());
    }

    @Test
    void isEmpty () {
        for (int i = 1; i <= 1000 ; i++){
            assertFalse(queue.isEmpty());
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    void isFull () {
        assertTrue(!queue.isFull());
    }
}