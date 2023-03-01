package lab01.tdd2;

import lab01.tdd.CircularListBase;
import lab01.tdd1.CircularList;

import java.util.Iterator;
import java.util.Optional;

public interface CircularListWithIterator extends CircularListBase {

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();

}
