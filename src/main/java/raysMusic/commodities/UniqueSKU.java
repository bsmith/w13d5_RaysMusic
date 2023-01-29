package raysMusic.commodities;

import raysMusic.behaviours.ISell;
import raysMusic.instruments.Instrument;

public class UniqueSKU implements ISell {
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
}
