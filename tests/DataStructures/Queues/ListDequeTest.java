package DataStructures.Queues;

import Utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListDequeTest {
    Deque<Integer> deque = new ListDeque<>();
    @Test
    void enqueue () {
        deque.enqueue(1);
    }

    @Test
    void dequeue () {
        deque.addFront(1);
        assertEquals(1 , deque.peekRear());
        deque.addRear(2);
        assertEquals(2 , deque.peekRear());
        assertEquals(1 , deque.peekFront());
        assertEquals(1 , deque.dequeue());
        assertEquals(2 , deque.removeFront());

    }

    @Test
    void peek () {
        assertNull(deque.peek());
        deque.enqueue(1);
        deque.enqueue(2);
        deque.enqueue(3);
        assertEquals(1 , deque.peekFront());
        assertEquals(3 , deque.peekRear());
    }

    @Test
    void size () {
        assertEquals(0 ,deque.size());
        addRandomIntsToDeque(2000);
        assertEquals(2000 , deque.size());
        deque.clear();
        assertEquals(0 , deque.size());
    }

    @Test
    void isEmpty () {
        assertTrue(deque.isEmpty());
        deque.enqueue(1);
        assertFalse(deque.isEmpty());
    }

    @Test
    void addFront () {
        deque.addFront(1);
        assertEquals(1 , deque.peekFront());
        deque.addFront(2);
        assertEquals(2 , deque.peekFront());
        deque.addFront(3);
        assertEquals(3 , deque.peekFront());

        assertEquals(1 , deque.peekRear());
        deque.addRear(0);
        assertEquals(0 , deque.peekRear());
    }

    @Test
    void addRear () {
        deque.addRear(1);
        assertEquals(1 , deque.peekRear());
        deque.addRear(2);
        assertEquals(2 , deque.peekRear());
        deque.addRear(3);
        assertEquals(3 , deque.peekRear());

        assertEquals(1 , deque.peekFront());
        deque.addFront(0);
        assertEquals(0 , deque.peekFront());
    }

    @Test
    void removeFront () {
        addRandomIntsToDeque(1000);
        for (int i = 1; i <= 1000 ; i++) {
            assertEquals(deque.peekFront() , deque.removeFront());
        }
        assertNull(deque.removeFront());
    }

    @Test
    void removeRear () {
        addRandomIntsToDeque(1000);
        for (int i = 1; i <= 1000 ; i++) {
            assertEquals(deque.peekRear() , deque.removeRear());
        }
        assertNull(deque.removeRear());
    }

    @Test
    void peekFront () {
        assertEquals(0 , deque.size());
        assertNull(deque.peekFront());
        deque.addFront(1);
        deque.addFront(2);
        assertEquals(2 , deque.peekFront());
        assertEquals(2 , deque.size());
    }

    @Test
    void peekRear () {
        assertEquals(0 , deque.size());
        assertNull(deque.peekRear());
        deque.addRear(1);
        deque.addRear(0);
        assertEquals(0 , deque.peekRear());
        assertEquals(2 , deque.size());
    }
    private void addRandomIntsToDeque(int limit){
        for (int i = 1; i <= limit; i++) {
            deque.enqueue(TestUtils.getRandomInt(100 , 3000));
        }
    }
}