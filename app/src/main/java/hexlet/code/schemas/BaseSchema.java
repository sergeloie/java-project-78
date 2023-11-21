package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    public List<Predicate<T>> predicates = new ArrayList<>();


    /**
     * @param object for validating
     * @return status of validation
     */
    public boolean isValid(T object) {

        if (object == null) {
            return predicates.stream().noneMatch(Objects::nonNull);
        }
        return predicates.stream().allMatch(predicate -> predicate.test(object));
    }


    public void addPredicate(Predicate<T> predicate) {
        predicates.add(predicate);
    }

    public boolean containsNullCheck() {
        return predicates.stream().anyMatch(Objects::nonNull);
    };

    public boolean notContainsNullCheck() {
        return predicates.stream().noneMatch(Objects::nonNull);
    }

}
