package lab01.tdd2;

import lab01.tdd.BaseCircularList;

import java.util.Iterator;

public interface CircularListWithIterator extends BaseCircularList {

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();

}
