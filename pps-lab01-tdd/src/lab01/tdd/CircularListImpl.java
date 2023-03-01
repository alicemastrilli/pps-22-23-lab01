package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private final List<Integer> circularList;
    private int indexOfElement;

    public CircularListImpl() {
        this.circularList = new ArrayList<>();
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
    public Optional<Integer> next() {
        if (this.isEmpty()){
            return Optional.empty();
        }
        if (++this.indexOfElement == this.size() ){
            this.indexOfElement = 0;
        }
        return Optional.of(this.circularList.get(indexOfElement));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()){
            return Optional.empty();
        }
        if (--this.indexOfElement < 0){
            this.indexOfElement = this.size()-1;
        }
        return Optional.of(this.circularList.get(indexOfElement));
    }

    @Override
    public void reset() {

    }
}
