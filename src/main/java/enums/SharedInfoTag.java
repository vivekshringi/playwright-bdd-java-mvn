package enums;

public enum SharedInfoTag {
    TEST("TEST"),
    PET("PET"),
    INVENTORY("INVENTORY"),
    USER("USER");

    private final String value;

    SharedInfoTag(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
