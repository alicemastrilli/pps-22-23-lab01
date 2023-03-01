package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListBaseImpl implements CircularListBase {
    private final List<Integer> circularList;

    public CircularListBaseImpl() {
        this.circularList = new ArrayList<>();
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
        return this.circularList;
    }
}
