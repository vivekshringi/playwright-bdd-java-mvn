package enums;

public enum SharedInfoTag {
    PRODUCT("PRODUCT");

    private final String value;

    SharedInfoTag(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
