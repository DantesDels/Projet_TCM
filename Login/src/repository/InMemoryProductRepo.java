package repository;

import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepo implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void updateByName(Product updatedProduct) {
        findByName(updatedProduct.getName()).ifPresent(product -> {
            product.setPrice(updatedProduct.getPrice());
        });
    }

    @Override
    public void deleteByName(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> findAll() {
        // Retourne une copie pour éviter que l'extérieur ne modifie la liste privée
        return new ArrayList<>(products);
    }

    @Override
    public Optional<Product> findById(int id) {
        // Si pas d'ID dans class Product, peut chercher par index
        // ou modifier modèle Product pour inclure un ID
        if (id >= 0 && id < products.size()) {
            return Optional.of(products.get(id));
        }
        return Optional.empty();
    }

    public Optional<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
