package raysMusic;

import raysMusic.behaviours.ICatalogueItem;
import raysMusic.behaviours.ISell;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Shop {
    HashSet<ICatalogueItem> stock;

    private Shop() {
        stock = new HashSet<>();
    }

    /* Let's try the Singleton pattern */
    static Shop theShop;
    static Shop getShop() {
        if (theShop == null)
            theShop = new Shop();
        return theShop;
    }

    void emptyStock() {
        stock.clear();
    }

    void addCatalogueItem(ICatalogueItem item) {
        stock.add(item);
    }

    List<ICatalogueItem> getAllItems() {
        /* I wanted to use sorted() to ensure a consistent order */
        return stock.stream().sorted(
                Comparator.comparing(ICatalogueItem::getType).thenComparing(
                        Comparator.comparing(ICatalogueItem::getShortName).thenComparing(
                                Comparator.comparing(ICatalogueItem::getDescription)
                        )
                )
        ).toList();
    }

    List<ICatalogueItem> getItemsOfType(String type) {
        return stock.stream()
                .filter(item -> Objects.equals(item.getType(), type))
                .sorted()
                .toList();
    }

    void removeItemsWithNoStock() {
        /* TODO: Why can this not be Iterator<IStock>? */
        /*Iterator<ICatalogueItem> iter = stock.iterator();
        while (iter.hasNext()) {
            IStock stock = iter.next();
            if (stock.getQuantity() == 0)
                iter.remove();
        }*/
        stock.removeIf(stock -> stock.getQuantity() == 0);
    }

    double totalMarkup() {
        double totalPurchasePrice = 0.0;
        double totalRetailPrice = 0.0;

        if (stock.size() == 0)
            return 0.0;

        for (ISell item : stock) {
            totalPurchasePrice += item.getPurchasePrice();
            totalRetailPrice += item.getRetailPrice();
        }

        return Util.calcMarkup(totalPurchasePrice, totalRetailPrice);
    }
}
