package project.business;

public enum BorrowTimeEnum {
    SEVEN(7),
    TWENTY_ONE(21);

    private final int value;

    BorrowTimeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}

