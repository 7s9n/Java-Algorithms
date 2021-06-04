package DataStructures.Lists;

import Utils.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    LinkedList<Integer> list = new DoublyLinkedList<>();
    @Test
    void size () {
        assertEquals(0 , list.size());
    }

    @Test
    void isEmpty () {
        assertTrue(list.isEmpty());
    }

    @Test
    void add () {
        addRandomNumberToList();
        assertEquals(1000 , list.size());
    }

    @Test
    void addFirst () {
        list.add(0 , 0);
        assertEquals(0 , list.getFirst());
        assertEquals(0 , list.getAt(0));
    }

    @Test
    void addLast () {
        addRandomNumberToList();
        list.addLast(90);
        assertEquals(90 , list.getLast());
        assertEquals(90 , list.getAt(list.size() - 1));
    }

    @Test
    void addBefore () {
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(4 , list.getAt(2));
        list.addBefore(3 , 4);
        assertEquals(3 , list.getAt(2));
        list.addBefore(0 , 1);
        assertEquals(0 , list.getAt(0));
        assertEquals(0 , list.getFirst());
    }

    @Test
    void addAfter () {
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(4 , list.getAt(2));
        list.addAfter(5 , 4);
        assertEquals(5 , list.getAt(3));
        list.addAfter(0 , 1);
        assertEquals(0 , list.getAt(1));
    }

    @Test
    void getFirst () {
        assertThrows(NoSuchElementException.class , ()-> list.getFirst());
        list.add(0 , 1);
        assertEquals(1 , list.getFirst());
    }

    @Test
    void getLast () {
        assertThrows(NoSuchElementException.class , ()-> list.getLast());
        list.add(0 , 1);
        list.add(1 , 2);
        assertEquals(2 , list.getLast());
    }

    @Test
    void getAt () {
        addRandomNumberToList();
        assertEquals(list.getFirst() , list.getAt(0));
    }

    @Test
    void removeFirst () {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(list.getFirst() , list.removeFirst());
        assertTrue(list.isEmpty());
        assertEquals(0 , list.size());
    }

    @Test
    void removeLast () {
        assertTrue(list.isEmpty());
        list.add(1);
        list.add(2);
        assertFalse(list.isEmpty());
        assertEquals(list.getLast() , list.removeLast());
        assertEquals(1, list.getLast());
        assertEquals(1 , list.size());
    }

    @Test
    void removeAt () {
        addRandomNumberToList();
        assertEquals(list.getAt(5) , list.removeAt(5));
    }

    @Test
    void indexOf () {
        addRandomNumberToList();
        assertEquals(list.getAt(0) , list.getAt(list.indexOf(list.getFirst())));
    }

    @Test
    void contains () {
        assertFalse(list.contains(1));
        list.add(1);
        assertTrue(list.contains(1));
        addRandomNumberToList();
        for (int i = 1; i <= 500 ; i++) {
            assertFalse(list.contains(TestUtils.getRandomInt(2000 , 5000)));
        }
    }

    @Test
    void clear () {
        addRandomNumberToList();

        assertEquals(1000 , list.size());
        assertFalse(list.isEmpty());

        list.clear();

        assertEquals(0 , list.size());
        assertTrue(list.isEmpty());
    }

    private void addRandomNumberToList(){
        for (int i = 1; i <= 1000; ++i){
            list.add(TestUtils.getRandomInt(1 , 1000));
        }
    }
}