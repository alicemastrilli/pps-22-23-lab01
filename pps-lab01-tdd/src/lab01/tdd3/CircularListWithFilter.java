package lab01.tdd3;

import lab01.tdd.CircularListBase;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListWithFilter extends CircularListBase {
    Optional<Integer> filteredNext(Predicate<Integer> condition);
}
