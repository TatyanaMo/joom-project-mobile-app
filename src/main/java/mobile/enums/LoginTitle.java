package mobile.enums;

public enum LoginTitle {
    LOGIN_TITLE("Log in");

    private final String value;
    LoginTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
