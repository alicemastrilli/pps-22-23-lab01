package lab01.tdd2;

import lab01.tdd.CircularListBase;
import lab01.tdd.CircularListBaseImpl;

import java.util.*;

public class CircularListWithIteratorImpl implements CircularListWithIterator {
    private final CircularListBase circularList;
    private int counter;
    public CircularListWithIteratorImpl() {
        this.circularList = new CircularListBaseImpl();
        this.counter = -1;
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public List<Integer> getElements() {
        return this.circularList.getElements();
    }
    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !circularList.isEmpty();
            }

            @Override
            public Integer next() {
                if (++counter == circularList.size()){
                    counter = 0;
                }
                return circularList.getElements().get(counter);
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return null;
    }
}
