package database;

public enum NumberCurrency {
    UAH("UAH"), USD("USD"), EUR("EUR"), RUB("RUR");

    private String string;

    NumberCurrency(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
