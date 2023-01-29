package raysMusic.behaviours;

public interface ICatalogueItem extends ISell, IStock {
    String getType();
    String getShortName();
    String getDescription();
}
