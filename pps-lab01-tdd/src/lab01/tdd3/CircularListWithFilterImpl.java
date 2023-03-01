package lab01.tdd3;

import lab01.tdd.CircularListBase;
import lab01.tdd.CircularListBaseImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CircularListWithFilterImpl implements CircularListWithFilter {
    private final CircularListBase circularList;
    private int elementPosition;
    public CircularListWithFilterImpl() {
        this.circularList = new CircularListBaseImpl();
        this.elementPosition = -1;
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
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        if (this.isEmpty()) {
            return Optional.empty();
        }
        this.elementPosition++;
        for(int i=0; i<this.getElements().size(); i++ ) {
            if(condition.test(this.getElements().get(computeIndexElement(i)))) {
                this.elementPosition= computeIndexElement(i);
                return Optional.of(this.getElements().get(elementPosition));
            }
        }
        return Optional.empty();
    }

    private int computeIndexElement(int i){
        return (this.elementPosition + i) % this.size();
    }
}
