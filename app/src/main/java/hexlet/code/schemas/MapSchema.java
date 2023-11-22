package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map> {

    private Map<String, BaseSchema> schemas = new HashMap<>();

    public MapSchema required() {
        addPredicate(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int x) {
        addPredicate(m -> m.size() == x);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> innerSchemas) {
        this.schemas = innerSchemas;
        return this;
    }

    public boolean innerCheck(Map<Object, Object> objectMap) {

        for (Map.Entry entry : objectMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (schemas.containsKey(key)) {
                BaseSchema sce = schemas.get(key);
                if (!sce.isValid(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isValid(Map object) {

        if (object != null && !schemas.isEmpty()) {
            return innerCheck(object);
        } else {
            return super.isValid(object);
        }
    }
}
