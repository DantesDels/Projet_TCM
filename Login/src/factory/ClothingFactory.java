package factory;

import models.Product;

public class ClothingFactory {
    private String name;
    private double price;

    public static Product createProduct(String name, double price) {
        return new Product(name, price);
    }
}
