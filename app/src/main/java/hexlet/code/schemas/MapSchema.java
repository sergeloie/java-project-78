package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {

    private boolean required = false;

    private boolean shouldSized = false;
    private int size = 0;

    private Map<String, BaseSchema> schemas = new HashMap<>();

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int x) {
        this.shouldSized = true;
        this.size = x;
        return this;
    }

    /**
     * @param object for validating
     * @return status of validation
     */
    @Override
    public boolean isValid(Object object) {
        if (object == null) {
            return !required;
        }

        if (!(object instanceof Map data)) {
            return false;
        }

        if (shouldSized && data.size() != size) {
            return false;
        }
        if (!schemas.isEmpty()) {
            return innerCheck(data);
        }
        return true;
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
}
