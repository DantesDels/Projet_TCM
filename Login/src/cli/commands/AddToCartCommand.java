package cli.commands;

import models.Product;
import models.ShoppingCart;
import repository.ProductRepository;
import java.util.Optional;
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
        System.out.print("Entrez le nom du produit à ajouter : ");
        String name = scanner.nextLine();
        Optional<Product> prod = repository.findByName(name);

        prod.ifPresentOrElse(
                product -> {
                    cart.addProduct(product);
                    System.out.println("✅ Produit '" + product.getName() + "' ajouté avec succès !");
                },
                () -> System.out.println("⚠️ Produit introuvable dans le catalogue.")
        );
    }
}