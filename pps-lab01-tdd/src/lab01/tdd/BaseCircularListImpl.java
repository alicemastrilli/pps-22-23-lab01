package lab01.tdd;

import java.util.ArrayList;
import java.util.List;

public class BaseCircularListImpl implements BaseCircularList {
    private final List<Integer> circularList;

    public BaseCircularListImpl() {
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
