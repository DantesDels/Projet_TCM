package models;

/**
 * Définit les rôles possibles pour un utilisateur du système.
 */

public enum UserRole {
    ADMIN("Administrateur"),
    CLIENT("Client standard");

    private final String label;

    UserRole(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}