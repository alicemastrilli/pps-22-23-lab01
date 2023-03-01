package lab01.tdd1;

import lab01.tdd.BaseCircularList;
import lab01.tdd.BaseCircularListImpl;

import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private final BaseCircularList circularList;
    private int indexOfElement;

    public CircularListImpl() {
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
        return this.circularList.size() == 0;
    }

    @Override
    public List<Integer> getElements() {
        return this.circularList.getElements();
    }

    @Override
    public Optional<Integer> next() {
        return computeElementToReturn(+1);
    }

    @Override
    public Optional<Integer> previous() {
        return computeElementToReturn(-1);
    }

    private Optional<Integer> computeElementToReturn(int valueToAddToActualIndex){
        if (this.isEmpty()){
            return Optional.empty();
        }
        this.indexOfElement += valueToAddToActualIndex;
        if (this.indexOfElement < 0){
            this.indexOfElement = this.size()-1;
        } else if(this.indexOfElement >=this.size()){
            this.indexOfElement = 0;
        }
        return Optional.of(this.getElements().get(indexOfElement));
    }
    @Override
    public void reset() {
        this.indexOfElement = -1;
    }
}
