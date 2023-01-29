package commodities;

import behaviours.ISell;

public class BulkSKU implements ISell {
    private final String type;
    private final String description;
    private final double purchasePrice;
    private final double retailPrice;
    private int quantity;

    public BulkSKU(String type, String description, double purchasePrice, double retailPrice, int quantity) {
        this.type = type;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public double getRetailPrice() {
        return retailPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void recordSale() {
        this.quantity--;
    }

    public void addStock(int newStock) {
        this.quantity += newStock;
    }
}
