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

        for (Predicate<T> predicate : predicates) {
            System.out.println(predicate.test(object));
        }

        return predicates.stream().allMatch(predicate -> predicate.test(object));
//
//        if (object == null && predicates.stream().noneMatch(predicate -> predicate == (Predicate<T>) Objects::nonNull)) {
//            return true;
//        }
//
//        return predicates.stream().allMatch(predicate -> predicate.test(object));

//        if (object == null) {
//            return predicates.isEmpty() ? true : predicates.stream().anyMatch(predicate -> !predicate.test(null));
//        }
//        return predicates.stream().allMatch(predicate -> predicate.test(object));
    };

    public void addPredicate(Predicate<T> predicate) {
        predicates.add(predicate);
    }

    public boolean containsNullCheck() {
        return predicates.stream().anyMatch(predicate -> predicate.test(null));
        };

}
