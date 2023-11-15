package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    private boolean required = false;
    private boolean positive = false;
    private Integer min = Integer.MIN_VALUE;
    private Integer max = Integer.MAX_VALUE;

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int a, int b) {
        this.min = a;
        this.max = b;
        return this;
    }

    @Override
    public boolean isValid(Object object) {

        if (object == null) {
            return !required;
        }

        if (!(object instanceof Integer data)) {
            return false;
        }

        if (positive && data <= 0) {
            return false;
        }
        if (data < min || data > max) {
            return false;
        }
        return true;
    }
}
