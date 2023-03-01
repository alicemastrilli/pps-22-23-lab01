package lab01.tdd2;

import lab01.tdd.BaseCircularList;
import lab01.tdd.BaseCircularListImpl;

import java.util.*;

public class CircularListWithIteratorImpl implements CircularListWithIterator {
    private final BaseCircularList circularList;
    private int indexOfElement;

    public CircularListWithIteratorImpl() {
        this.circularList = new BaseCircularListImpl();
        this.indexOfElement = -1;
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
        return this.computeIterator(1);

    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return this.computeIterator(-1);

    }

    private Iterator<Integer> computeIterator(int valueToAddToCounter){
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !circularList.isEmpty();
            }

            @Override
            public Integer next() {
                indexOfElement += valueToAddToCounter;
                if (indexOfElement < 0) {
                    indexOfElement = circularList.size()-1;
                } else if(indexOfElement == circularList.size()){
                    indexOfElement = 0;
                }
                return circularList.getElements().get(indexOfElement);
            }
        };
    }
}