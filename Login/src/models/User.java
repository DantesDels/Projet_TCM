package models;

public class User {
    private String name;
    private ShoppingCart shoppingCart;

    public User() {
        this.name = "";
        this.shoppingCart = new ShoppingCart();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }
}
