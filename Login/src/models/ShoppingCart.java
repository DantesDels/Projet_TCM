package models;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> products;

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        int currentQuantity = products.getOrDefault(product, 0);
        products.put(product, currentQuantity + 1);
    }

    public double calculateTotal() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Le panier est vide.");
            return;
        }
        System.out.println("\n--- Votre Panier ---");
        products.forEach((product, quantity) -> {
            System.out.println("- " + product.getName() + " x" + quantity +
                    " (" + (product.getPrice() * quantity) + "€)");
        });
        System.out.println("Total brut : " + calculateTotal() + "€");
    }
}
