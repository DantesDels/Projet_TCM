package cli.commands;

import models.Product;
import models.ShoppingCart;
import repository.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class AddToCartCommand implements core.Command {
    private final ShoppingCart cart;
    private final ProductRepository repository;
    private final Scanner scanner;

    public AddToCartCommand(ShoppingCart cart, ProductRepository repository, Scanner scanner) {
        this.cart = cart;
        this.repository = repository;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter un produit au panier";
    }

    @Override
    public void execute() {
        List<Product> products = repository.findAll();

        if (products.isEmpty()) {
            System.out.println("⚠️ Le catalogue est vide.");
            return;
        }

        // Afficher la liste numérotée
        System.out.println("\n--- Produits disponibles ---");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " (" + p.getPrice() + "€)");
        }

        try {
            // Sélection du produit par son numéro
            System.out.print("\nSélectionnez le numéro du produit : ");
            int productIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (productIndex < 0 || productIndex >= products.size()) {
                System.out.println("⚠️ Numéro invalide.");
                return;
            }

            Product selectedProduct = products.get(productIndex);

            // Demander la quantité
            System.out.print("Quantité souhaitée : ");
            int quantity = Integer.parseInt(scanner.nextLine());

            if (quantity <= 0) {
                System.out.println("⚠️ La quantité doit être supérieure à 0.");
                return;
            }

            // Ajouter au panier
            for (int i = 0; i < quantity; i++) {
                cart.addProduct(selectedProduct);
            }

            System.out.println("✅ x" + quantity + " ajouté(s) au panier !");

        } catch (NumberFormatException e) {
            System.out.println("⚠️ Erreur : Veuillez entrer un nombre valide.");
        }
    }
}