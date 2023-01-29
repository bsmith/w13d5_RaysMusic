package raysMusic.commodities;

import raysMusic.behaviours.ICatalogueItem;
import raysMusic.behaviours.ISell;
import raysMusic.instruments.Instrument;

public class UniqueSKU implements ISell, ICatalogueItem {
    private final Instrument instrument;
    private final double purchasePrice;
    private final double retailPrice;
    private boolean sold;

    public UniqueSKU(Instrument instrument, double purchasePrice, double retailPrice) {
        this.instrument = instrument;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.sold = false;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public String getType() {
        return "Instrument";
    }

    public String getShortName() {
        return instrument.getShortName();
    }

    public String getDescription() {
        return instrument.getDescription();
    }

    @Override
    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public double getRetailPrice() {
        return retailPrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void markSold() {
        sold = true;
    }

    public int getQuantity() {
        return isSold() ? 0 : 1;
    }

    public void recordSale() {
        markSold();
    }
}
