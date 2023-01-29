package raysMusic;

import raysMusic.behaviours.ISell;

public class Util {
    public static double calcMarkup(ISell iSell) {
        return calcMarkup(iSell.getPurchasePrice(), iSell.getRetailPrice());
    }

    public static double calcMarkup(double purchase, double sell) {
        return sell / purchase;
    }
}
