package lab01.tdd3;

import lab01.tdd.BaseCircularList;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListWithFilter extends BaseCircularList {
    Optional<Integer> filteredNext(Predicate<Integer> condition);
}
