package lab01.tdd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithIteratorTest {
    private CircularListWithIterator circularList;

    @BeforeEach
    void setUp() {
        circularList = new CircularListWithIteratorImpl();
    }

    @Test
    void testForwardIterator(){
        assertFalse(circularList.forwardIterator().hasNext());
        circularList.add(1);
        circularList.add(2);
        Iterator<Integer> forwardIterator = circularList.forwardIterator();
        assertTrue(circularList.forwardIterator().hasNext());
        assertEquals(1, forwardIterator.next());
        assertEquals(2, forwardIterator.next());
        assertEquals(1, forwardIterator.next());
        assertEquals(2, forwardIterator.next());
    }

    @Test
    void testBackwardIterator(){
        assertFalse(circularList.backwardIterator().hasNext());
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        Iterator<Integer> backwardIterator = circularList.backwardIterator();
        assertTrue(circularList.backwardIterator().hasNext());
        assertEquals(3, backwardIterator.next());
        assertEquals(2, backwardIterator.next());
        assertEquals(1, backwardIterator.next());
        assertEquals(3, backwardIterator.next());
    }
}