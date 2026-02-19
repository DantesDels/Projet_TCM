package cli.commands;

import core.Command;
import models.Product;
import repository.ProductRepository;
import java.util.List;

public class ShowCatalogueCommand implements Command {
    private final ProductRepository productRepository;

    public ShowCatalogueCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String getLabel() {
        return "Afficher le catalogue";
    }

    @Override
    public void execute() {
        System.out.println("\n--- CATALOGUE DES PRODUITS ---");

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            System.out.println("Le catalogue est actuellement vide.");
            return;
        }

        for (Product product : products) {
            // Java va chercher dynamiquement la méthode display() :
            // - Celle de Product si c'est un produit simple
            // - Celle de DiscountDecorator si le produit est décoré
            product.display();
        }

        System.out.println("------------------------------\n");
    }
}