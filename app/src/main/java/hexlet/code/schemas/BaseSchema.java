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

//        if (predicates.isEmpty()) {
//            return true;
//        }

        if (object != null) {
            return predicates.stream().allMatch(predicate -> predicate.test(object));
        } else {
            for (Predicate<T> predicate : predicates) {
                try {
                    if (!predicate.test(null)) {
                        return false;
                    }
                } catch (NullPointerException npe) {
                    System.out.println("Ошибка. NullPointerException !!!!11111адинадин");
                }
            }
        }
        return true;
    }


    public void addPredicate(Predicate<T> predicate) {
        predicates.add(predicate);
    }

//    public boolean containsNullCheck() {
//
//        return predicates.stream().anyMatch(predicate -> predicate.test());
//    };
//
//    public boolean notContainsNullCheck() {
//        return predicates.stream().noneMatch(Objects::nonNull);
//    }



}
