package entities;

public class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + customsFee;
    }

    @Override
    public String priceTag() {

        return getName() + " $ " + getPrice() + " (Customs fee: " + String.format("%.2f", customsFee) + ")";
    }
}
