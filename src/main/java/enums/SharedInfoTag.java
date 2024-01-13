package enums;

public enum SharedInfoTag {
    COFFEE("COFFEE");

    private final String value;

    SharedInfoTag(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
