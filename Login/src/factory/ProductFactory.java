package factory;

import models.Product;
import models.Clothing;

public class ProductFactory {

    public static Product createProduct(String type, String name, double price) {
        if (type == null) return null;

        return switch (type.toUpperCase()) {
            case "CLOTHING" -> new Clothing(name, price);
            // case "CHAUSSURES" -> new Chaussures(args) SI Classe "Chaussures" créée.
            default -> throw new IllegalArgumentException("Type de produit inconnu : " + type);
        };
    }
}