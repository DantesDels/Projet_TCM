package util;

import models.*;
import repository.ProductRepository;
import repository.UserRepository;

public class SeedData {

    public static void init(ProductRepository productRepo, UserRepository userRepo) {
        // Produits normaux
        productRepo.save(new Clothing("T-shirt Oversize", 29.99));

        // Produits en promo via notre helper
        savePromo(productRepo, "Jean Denim Bleu", 59.90, 20);
        savePromo(productRepo, "Casquette Vintage", 15.50, 50);
        savePromo(productRepo, "Sweat à capuche", 45.00, 10);

        userRepo.save(new User("admin@shop.fr", "admin123", "ADMIN"));

        System.out.println("[Système] Données chargées.");
    }

    private static void savePromo(ProductRepository repo, String name, double price, int percentDiscount) {
        Product product = new Clothing(name, price);
        repo.save(new DiscountDecorator(product, percentDiscount));
    }
}