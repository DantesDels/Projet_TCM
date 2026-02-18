package util;

import models.Product;
import models.User;
import repository.ProductRepository;
import repository.UserRepository;

public class SeedData {

    public static void init(ProductRepository productRepo, UserRepository userRepo) {
        // Initialisation des Produits
        productRepo.save(new Product("T-shirt Oversize", 29.99));
        productRepo.save(new Product("Jean Denim Bleu", 59.90));
        productRepo.save(new Product("Sweat à capuche Noir", 45.00));
        productRepo.save(new Product("Casquette Vintage", 15.50));

        // Initialisation des Utilisateurs
        userRepo.save(new User("admin123", "admin@shop.fr", "ADMIN"));
        userRepo.save(new User("client123", "client@shop.fr", "CLIENT"));

        System.out.println("[Système] Données de démonstration chargées avec succès.");
    }
}