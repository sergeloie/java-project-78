package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {



    private boolean required = false;

    private List<Predicate<Object>> predicates = new ArrayList<>();

    /**
     * @param object for validating
     * @return status of validation
     */
    public boolean isValid(Object object) {

        if (checkIfNull(object)) {
            return !required;
        } else {
            return predicates.stream().allMatch(predicate -> predicate.test(object));
        }
    }

    /**
     * @param predicate for validating
     */
    public void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    /**
     * @param object to check if Null or Empty
     * @return result of checking
     */
    public boolean checkIfNull(Object object) {
        return object == null;
    }

    /**
     * @param required set reqired field
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

}
