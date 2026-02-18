package models;

public class DiscountDecorator extends ProductDecorator {
    private final int percentage;

    public DiscountDecorator(Product decoratedProduct, int percentage) {
        super(decoratedProduct);
        this.percentage = percentage;
    }

    @Override
    public void display() {
        System.out.print(" [ PROMO -" + percentage + "% ]");
        decoratedProduct.display();
    }
}