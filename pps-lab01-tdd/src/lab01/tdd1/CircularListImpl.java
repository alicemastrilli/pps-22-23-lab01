package lab01.tdd1;

import lab01.tdd.CircularListBase;
import lab01.tdd.CircularListBaseImpl;
import lab01.tdd1.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private final CircularListBase circularList;
    private int indexOfElement;

    public CircularListImpl() {
        this.circularList = new CircularListBaseImpl();
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
        return this.circularList.size() == 0;
    }

    @Override
    public List<Integer> getElements() {
        return this.circularList.getElements();
    }

    @Override
    public Optional<Integer> next() {
        if (this.isEmpty()){
            return Optional.empty();
        }
        if (++this.indexOfElement == this.size() ){
            this.indexOfElement = 0;
        }
        return Optional.of(this.getElements().get(indexOfElement));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()){
            return Optional.empty();
        }
        if (--this.indexOfElement < 0){
            this.indexOfElement = this.size()-1;
        }
        return Optional.of(this.getElements().get(indexOfElement));
    }

    @Override
    public void reset() {
        this.indexOfElement = -1;
    }
}
