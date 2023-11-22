package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private List<Predicate<T>> predicates = new ArrayList<>();

    /**
     * @param object for validating
     * @return status of validation
     */
    public boolean isValid(T object) {

        if (object != null) {
            return predicates.stream().allMatch(predicate -> predicate.test(object));
        } else {
            for (Predicate<T> predicate : predicates) {
                try {
                    if (!predicate.test(null)) {
                        return false;
                    }
                } catch (NullPointerException ignored) {
                }
            }
        }
        return true;
    }

    /**
     * @param predicate for validating
     */
    public void addPredicate(Predicate<T> predicate) {
        predicates.add(predicate);
    }

}
