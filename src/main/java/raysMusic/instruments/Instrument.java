package raysMusic.instruments;

public abstract class Instrument {
    private final String material;
    private final String colour;

    public Instrument(String material, String colour) {
        this.material = material;
        this.colour = colour;
    }

    public String getMaterial() {
        return material;
    }

    public String getColour() {
        return colour;
    }

    abstract public Section getSection();
    abstract String getDescription();
    abstract String getShortName();
}
