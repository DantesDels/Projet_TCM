package repository;

import models.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    // Sauvegarder un nouvel utilisateur (Inscription)
    void save(User user);

    // Trouver un utilisateur par son email (Login)
    Optional<User> findByEmail(String email);

    // Récupérer tous les utilisateurs (Admin)
    List<User> findAll();

    // Supprimer un compte
    void deleteByEmail(String email);
}