package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {


    public StringSchema required() {
        addPredicate(Objects::nonNull);
        addPredicate(s -> !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
        addPredicate(s -> s.length() >= minLength);
        return this;
    }

    public StringSchema contains(String contains) {
        addPredicate(s -> s.contains(contains));
        return this;
    }
}
