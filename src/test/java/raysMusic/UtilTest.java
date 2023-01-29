package raysMusic;

import raysMusic.Util;
import raysMusic.commodities.BulkSKU;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {
    BulkSKU bulkSKU;

    @Before
    public void setUp() {
        bulkSKU = new BulkSKU("strings", "Guitar Strings", 10.00, 15.00, 100);
    }

    @Test
    public void canCalulateMarkup() {
        double markup = Util.calcMarkup(10, 20);
        assertEquals(2.00, markup, 0.001);
    }

    @Test
    public void canCalculateMarkupOfCommodity() {
        double markup = Util.calcMarkup(bulkSKU);
        assertEquals(1.50, markup, 0.001);
    }

}