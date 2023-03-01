package lab01.tdd3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithFilterTest {
    private CircularListWithFilter circularList;
    @BeforeEach
    void setUp() {
        circularList = new CircularListWithFilterImpl();
    }
    @Test
    void testGetFilteredNext(){
        assertEquals(Optional.empty(), circularList.filteredNext(i -> i>=0));
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.add(5);
        assertEquals(Optional.of(1), circularList.filteredNext(i -> i>=0));
        assertEquals(Optional.of(2), circularList.filteredNext(i -> i>=0));
        assertEquals(Optional.of(4), circularList.filteredNext(i -> i%2 ==0));
        assertEquals(Optional.of(1), circularList.filteredNext(i -> i<4));
        assertEquals(Optional.of(3), circularList.filteredNext(i -> i%2 == 1));
        assertEquals(Optional.of(5), circularList.filteredNext(i -> i%2 == 1));
        assertEquals(Optional.empty(), circularList.filteredNext(i -> i>6));

    }
}