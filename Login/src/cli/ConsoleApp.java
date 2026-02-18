package cli;

import cli.commands.AddProductCommand;
import cli.commands.AddToCartCommand;
import models.ShoppingCart;
import repository.InMemoryProductRepo;
import repository.InMemoryUserRepo;
import repository.ProductRepository;
import repository.UserRepository;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        ProductRepository productRepository = new InMemoryProductRepo();
        UserRepository userRepo = new InMemoryUserRepo();

        util.SeedData.init(productRepository, userRepo);

        MenuHandler menu = new MenuHandler(scanner);

        // Liste des commandes visibles/ajoutées
        menu.addCommand(new AddProductCommand(productRepository, scanner));
        menu.addCommand(new AddToCartCommand(cart, productRepository, scanner));

        System.out.println("=== BIENVENUE SUR VOTRE SHOP V2.0 ===");
        menu.start();
        scanner.close();
    }
}