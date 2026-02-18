package util;

import factory.UserBuilder;
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

        // Création d'un Admin avec le Builder
        User admin = new UserBuilder()
                .withName("Admin")
                .withEmail("admin@shop.fr")
                .withRole("ADMIN")
                .build();

        // Création d'un Client (le rôle sera "CLIENT" par défaut)
        User client = new UserBuilder()
                .withName("Jean Dupont")
                .withEmail("jean@gmail.com")
                .build();

        userRepo.save(admin);
        userRepo.save(client);

        System.out.println("[Système] Données chargées.");
    }

    private static void savePromo(ProductRepository repo, String name, double price, int percentDiscount) {
        Product product = new Clothing(name, price);
        repo.save(new DiscountDecorator(product, percentDiscount));
    }
}