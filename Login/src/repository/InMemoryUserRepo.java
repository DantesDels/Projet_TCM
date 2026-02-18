package repository;

import models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepo implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        // Vérifie si l'utilisateur n'existe pas déjà
        if (findByEmail(user.getEmail()).isEmpty()) {
            users.add(user);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        // Retourne une copie pour protéger la liste originale (Encapsulation)
        return new ArrayList<>(users);
    }

    @Override
    public void deleteByEmail(String email) {
        // Supprime l'utilisateur si l'email correspond
        users.removeIf(u -> u.getEmail().equalsIgnoreCase(email));
    }
}