package models;

public abstract class ProductDecorator extends Product {
    protected final Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        super(decoratedProduct.getName(), decoratedProduct.getPrice());
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public void display() {
        decoratedProduct.display();
    }
}