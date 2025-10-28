package mobile.enums;

public enum AccountTitle {
    NEW_USER_DATA("Nick_Tester"),
    MY_ORDERS_TITLE("My orders");

    private final String value;

    AccountTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

