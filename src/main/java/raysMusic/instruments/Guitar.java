package raysMusic.instruments;

import raysMusic.behaviours.IPlay;

public class Guitar extends Instrument implements IPlay {
    private final int strings;
    private final GuitarType type;

    public Guitar(String material, String colour, int strings, GuitarType type) {
        super(material, colour);
        this.strings = strings;
        this.type = type;
    }

    public int getStrings() {
        return strings;
    }

    public GuitarType getType() {
        return type;
    }

    public String getTypeAsString() {
        return switch (type) {
            case CLASSICAL -> "Classical guitar";
            case ELECTRIC -> "Electric guitar";
            case BASS -> "Bass guitar";
            case UKULELE -> "Ukulele";
        };
    }

    @Override
    public Section getSection() {
        return Section.STRINGS;
    }

    @Override
    String getDescription() {
        return String.format("%s in %s %s with %s strings",
                getTypeAsString(), getColour(), getMaterial(), getStrings());
    }

    @Override
    String getShortName() {
        return getTypeAsString();
    }

    @Override
    public String play() {
        return switch (type) {
            case CLASSICAL -> "Beautiful melodies";
            case ELECTRIC -> "Amazing chords";
            case BASS -> "Bass stuff";
            case UKULELE -> "Music of a kind";
        };
    }
}
