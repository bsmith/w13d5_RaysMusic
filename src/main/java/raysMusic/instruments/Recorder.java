package raysMusic.instruments;

import raysMusic.behaviours.IPlay;

public class Recorder extends Instrument implements IPlay {
    private final RecorderType type;
    private final String manufacturer;

    public Recorder(String material, String colour, RecorderType type, String manufacturer) {
        super(material, colour);
        this.type = type;
        this.manufacturer = manufacturer;
    }

    public RecorderType getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String play() {
        return "Sublime baroque music";
    }

    @Override
    public Section getSection() {
        return Section.WOODWINDS;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getShortName() {
        return null;
    }
}
