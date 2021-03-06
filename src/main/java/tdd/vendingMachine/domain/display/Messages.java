package tdd.vendingMachine.domain.display;

public enum Messages {

    IDLE("Please choose product"),
    PRODUCT_SELECTED("Selected product: %s, price: %.2f"),
    PRODUCT_TRAY_EMPTY("Product tray empty, choose another"),
    COINS_INSERTED("Inserted amount: %.2f, required more: %.2f"),
    DISPENSING("Dispensing product: %s"),
    GIVING_BACK_CHANGE("Giving back change: %.2f"),
    CANCELLED("Action cancelled"),
    CANCELLED_WITH_RETURN("Action cancelled, returning: %.2f"),
    NOT_ENOUGH_MONEY_TO_GIVE_BACK_CHANGE("Machine cannot return change, action cancelled, returning: %.2f");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
