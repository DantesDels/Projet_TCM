package services;

import core.DiscountStrategy;
import models.User;

public class OrderService {

    public void processOrder(User user, DiscountStrategy strategy) {
        double totalInitial = user.getShoppingCart().calculateTotal();
        double totalApresRemise = strategy.applyDiscount(totalInitial);

        System.out.println("Total initial : " + totalInitial + "€");
        System.out.println("Remise : " + strategy.getDescription());
        System.out.println("À payer : " + totalApresRemise + "€");
    }
}
