package raysMusic.commodities;

import raysMusic.Util;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BulkSKUTest {
    BulkSKU bulkSKU;

    @Before
    public void setUp() {
        bulkSKU = new BulkSKU("Strings", "Guitar Strings", 10.00, 15.00, 100);
    }

    @Test
    public void canGetQuantity() {
        assertEquals(100, bulkSKU.getQuantity());
    }

    @Test
    public void canRecordSale() {
        bulkSKU.recordSale();
        assertEquals(99, bulkSKU.getQuantity());
    }

    @Test
    public void canAddStock() {
        bulkSKU.addStock(10);
        assertEquals(110, bulkSKU.getQuantity());
    }

    @Test
    public void canCalculateMarkup() {
        double markup = Util.calcMarkup(bulkSKU);
        assertEquals(1.50, markup, 0.001);
    }

    /* Test the ICatalogueItem interface */
    @Test
    public void hasType() {
        assertEquals("Strings", bulkSKU.getType());
    }

    @Test
    public void hasShortName() {
        assertEquals("Guitar Strings", bulkSKU.getShortName());
    }

    @Test
    public void truncatesLongDescriptionsForShortName() {
        bulkSKU = new BulkSKU("Strings", "Guitar Strings for a special guitar", 10.00, 15.00, 100);
        assertEquals("Guitar Strings for a spec...", bulkSKU.getShortName());
    }

    @Test
    public void hasDescription() {
        assertEquals("Guitar Strings", bulkSKU.getDescription());
    }
}