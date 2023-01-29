package raysMusic.commodities;

import raysMusic.commodities.BulkSKU;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BulkSKUTest {
    BulkSKU bulkSKU;

    @Before
    public void setUp() {
        bulkSKU = new BulkSKU("strings", "Guitar Strings", 10.00, 15.00, 100);
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
}