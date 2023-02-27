import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    void testListInitiallyEmpty(){
        assertEquals(0, this.circularList.size());
    }

    @Test
    void testAddNewElement(){
        circularList.add(1);
        circularList.add(2);
        assertEquals(2, circularList.size());
    }

    @Test
    void testIsEmptyList(){
        assertTrue(this.circularList.isEmpty());
        circularList.add(3);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void testGetNextElement(){
        assertEquals(Optional.empty(), circularList.next());
        circularList.add(1);
        circularList.add(2);
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(2), circularList.next());
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testGetPreviousElement(){
        assertEquals(Optional.empty(), circularList.previous());
        circularList.add(1);
        circularList.add(2);
        assertEquals(Optional.of(2), circularList.previous());
        assertEquals(Optional.of(1), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
    }
}
