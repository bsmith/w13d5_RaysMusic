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
    public void setUp() throws Exception {
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
}