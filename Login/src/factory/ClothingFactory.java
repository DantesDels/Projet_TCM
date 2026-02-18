package factory;

import models.Product;

public class ClothingFactory {
    private String name;
    private double price;

    public ClothingFactory(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static Product createProduct(String name, double price) {
        return new Product(name, price);
    }
}
