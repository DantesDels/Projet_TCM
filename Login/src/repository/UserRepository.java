package repository;

import models.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    // Sauvegarder un nouvel utilisateur (ex: Inscription)
    void save(User user);

    // Trouver un utilisateur par son email (Indispensable pour le Login)
    // Optional pour gérer proprement le cas "Utilisateur non trouvé"
    Optional<User> findByEmail(String email);

    // Récupérer tous les utilisateurs (Utile pour une vue Admin)
    List<User> findAll();

    // Supprimer un compte
    void deleteByEmail(String email);
}