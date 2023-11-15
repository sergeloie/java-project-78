package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    private boolean required = false;
    private int minlength = 0;
    private String subString = "";

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minlength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.subString = contains;
        return this;
    }


    @Override
    public boolean isValid(Object object) {
        if (object == null) {
            return !required;
        }
        if (!(object instanceof String data)) {
            return false;
        }
        if (data.isEmpty()) {
            return !required;
        }
        if (data.length() < minlength) {
            return false;
        }
        if (!data.contains(subString)) {
            return false;
        }
        return true;
    }


}
