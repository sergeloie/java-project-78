package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addPredicate(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addPredicate(i -> i > 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        addPredicate(i -> (i >= a && i <= b));
        return this;
    }
}
