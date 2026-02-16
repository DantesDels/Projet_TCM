package core;

public interface DiscountStrategy {
    double applyDiscount(double totalAmount);
    String getDescription();
}
