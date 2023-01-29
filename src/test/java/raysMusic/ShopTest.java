package raysMusic;

import org.junit.Before;
import org.junit.Test;
import raysMusic.behaviours.ICatalogueItem;
import raysMusic.commodities.BulkSKU;
import raysMusic.commodities.UniqueSKU;
import raysMusic.instruments.Guitar;
import raysMusic.instruments.GuitarType;
import raysMusic.instruments.Instrument;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ShopTest {
    ICatalogueItem item1, item2, item3;
    Shop shop;

    @Before
    public void setUp() {
        /* clear up the singleton in between tests */
        shop = Shop.getShop();
        Shop.getShop().emptyStock();

        item1 = new BulkSKU("Strings", "Guitar Strings", 10.00, 15.00, 10);
        item2 = new BulkSKU("Sheet Music", "Smoke on Water", 15.00, 20.00, 5);
        Instrument instrument = new Guitar("Balsa", "White", 5, GuitarType.ELECTRIC);
        item3 = new UniqueSKU(instrument, 100.00, 250.00);
    }

    @Test
    public void shopStartsEmpty() {
        assertEquals(0, shop.getAllItems().size());
    }

    @Test
    public void canAddCatalogueItem() {
        shop.addCatalogueItem(item1);
        shop.addCatalogueItem(item2);
        assertEquals(Set.of(item1, item2), Set.copyOf(shop.getAllItems()));
    }

    @Test
    public void canGetItemsOfType() {
        shop.addCatalogueItem(item1);
        shop.addCatalogueItem(item2);
        assertEquals(List.of(item1), shop.getItemsOfType("Strings"));
        assertEquals(List.of(item2), shop.getItemsOfType("Sheet Music"));
    }

    @Test
    public void removeItemsWithNoStock() {
        shop.addCatalogueItem(item1);
        shop.addCatalogueItem(item2);
        shop.addCatalogueItem(item3);
        item3.recordSale();
        for (int i = 0; i < 5; i++)
            item2.recordSale();
        shop.removeItemsWithNoStock();
        assertEquals(List.of(item1), shop.getAllItems());
        assertEquals(0, item3.getQuantity());
        assertEquals(0, item2.getQuantity());
        assertEquals(10, item1.getQuantity());
    }

    @Test
    public void canCalculateTotalMarkup() {
        shop.addCatalogueItem(item1);
        shop.addCatalogueItem(item2);
        shop.addCatalogueItem(item3);
        double markup = shop.totalMarkup();
        assertEquals(2.28, markup, 0.001);
    }

    @Test
    public void emptyShopHasZeroMarkup() {
        double markup = shop.totalMarkup();
        assertEquals(0, markup, 0.001);
    }
}