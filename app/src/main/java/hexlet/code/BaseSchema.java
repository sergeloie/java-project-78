package hexlet.code;

public abstract class BaseSchema {

    /**
     * @param object for validating
     * @return status of validation
     */
    public abstract boolean isValid(Object object);
}
