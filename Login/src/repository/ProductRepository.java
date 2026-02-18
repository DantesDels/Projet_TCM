package repository;

import models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    void updateByName(Product product);

    void deleteByName(Product product);

    List<Product> findAll();

    Optional<Product> findById(int id);

    Optional<Product> findByName(String name);
}
