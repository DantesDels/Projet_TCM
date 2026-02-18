package models;

import java.util.Objects;

public class Product {
    // Pas de Final pour permettre la modification future de ces attributs.
    private String name;
    private double price;

    public Product(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() { return this.name; }

    public double getPrice() {
        return this.price;
    }

    public void display(String indent) {
        System.out.println(indent + "- " + name + " : " + price + "€");
    }

    public boolean equals(Object object) {
        // Vérification de l'identité (si même adresse mémoire)
        if (this == object) return true;

        // Vérification du type et de la nullité
        if (object == null || getClass() != object.getClass()) return false;

        // Comparaison des attributs significatifs
        Product product = (Product) object;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    public int hashCode() {
        // Génère un hash unique basé sur le nom et le prix
        return Objects.hash(name, price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
