package cli;

import repository.InMemoryProductRepo;
import repository.ProductRepository;
import repository.UserRepository;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductRepository productRepo = new InMemoryProductRepo();
        UserRepository userRepo = new InMemoryUserRepo();

        SeedData.init(productRepo, userRepo);

        MenuHandler menu = new MenuHandler(scanner, productRepo, userRepo);

        System.out.println("=== BIENVENUE SUR VOTRE SHOP V2.0 ===");
        menu.start(); // Lance la boucle while(true)

        scanner.close();
    }
}