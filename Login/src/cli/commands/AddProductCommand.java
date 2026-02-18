package cli.commands;

import core.Command;
import factory.ClothingFactory;
import models.Product;
import repository.ProductRepository;

import java.util.Scanner;

public class AddProductCommand implements Command {
    private final ProductRepository productRepository;
    private final Scanner scanner;

    public AddProductCommand(ProductRepository productRepository, Scanner scanner) {
        this.productRepository = productRepository;
        this.scanner = scanner;
    }


    @Override
    public String getLabel() {
        return "Ajouter un nouveau produit au catalogue"; // Rôle Admin
    }

    @Override
    public void execute() {
        System.out.println("\n--- Ajout d'un produit ---");

        System.out.print("Nom du produit : ");
        String name = scanner.nextLine();

        System.out.print("Prix du produit : ");
        double price = Double.parseDouble(scanner.nextLine());

        // Utilisation de la Factory pour créer l'objet
        Product newProduct = ClothingFactory.createProduct(name, price);

        // Sauvegarde dans le repository
        productRepository.save(newProduct);

        System.out.println("✅ Produit '" + name + "' ajouté avec succès !");
    }
}
