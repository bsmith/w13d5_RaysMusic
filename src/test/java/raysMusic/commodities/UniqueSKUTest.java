package raysMusic.commodities;

import raysMusic.Util;
import raysMusic.instruments.Guitar;
import raysMusic.instruments.GuitarType;
import raysMusic.instruments.Instrument;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueSKUTest {
    Instrument instrument;
    UniqueSKU uniqueSKU;

    @Before
    public void setUp() {
        instrument = new Guitar("Balsa", "White", 5, GuitarType.ELECTRIC);
        uniqueSKU = new UniqueSKU(instrument, 100, 250);
    }

    @Test
    public void startsUnsold() {
        assertFalse(uniqueSKU.isSold());
    }

    @Test
    public void canMarkSold() {
        uniqueSKU.markSold();
        assertTrue(uniqueSKU.isSold());
    }

    @Test
    public void canCalculateMarkup() {
        double markup = Util.calcMarkup(uniqueSKU);
        assertEquals(2.50, markup, 0.001);
    }

    /* Test the ICatalogueItem interface */
    @Test
    public void hasType() {
        assertEquals("Instrument", uniqueSKU.getType());
    }

    @Test
    public void hasShortName() {
        assertEquals("Electric guitar", uniqueSKU.getShortName());
    }

    @Test
    public void hasDescription() {
        assertEquals("Electric guitar in White Balsa with 5 strings", uniqueSKU.getDescription());
    }

    /* Test the IStock interface */
    public void hasGetQuantity() {
        assertEquals(1, uniqueSKU.getQuantity());
    }

    public void canRecordSale() {
        uniqueSKU.recordSale();
        assertEquals(0, uniqueSKU.getQuantity());
    }
}