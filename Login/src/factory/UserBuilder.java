package factory;

import models.User;

public class UserBuilder {
    private String name;
    private String email;
    private String role = "CLIENT"; // par défaut

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public User build() {
        if (name == null || email == null) {
            throw new IllegalStateException("Pseudo et Email sont obligatoires.");
        }
        return new User(name, email, role);
    }
}