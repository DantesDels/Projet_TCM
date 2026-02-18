package models;

public class User extends BaseEntity {
    private String name;
    private String email;
    private ShoppingCart shoppingCart;

    public String role;

    public User(String name, String email, String role) {
        super();
        this.name = "";
        this.email = "";
        this.role = "";
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

    public String getEmail() {
        return this.email;
    }
}
