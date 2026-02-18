package models;

import java.util.Objects;

public class Product extends BaseEntity {
    // Pas de Final pour permettre la modification future de ces attributs.
    private String name;
    private double price;

    public Product(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() { return this.name; }

    public double getPrice() {
        return this.price;
    }

    // Affichage simple
    public void display(String indent) {
        System.out.println(indent + "- " + name + " : " + price + "€");
    }

    // Affichage pour décorateur
    public void display(){
        this.display("");
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

    public void setPrice(double price) {
        this.price = price;
    }
}
