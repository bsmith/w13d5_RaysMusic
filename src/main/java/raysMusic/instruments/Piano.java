package raysMusic.instruments;

import raysMusic.behaviours.IPlay;

public class Piano extends Instrument implements IPlay {
    private final int keys;
    private final int width;
    private final int height;
    private final int depth;

    public Piano(String material, String colour, int keys, int width, int height, int depth) {
        super(material, colour);
        this.keys = keys;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getKeys() {
        return keys;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String play() {
        return "Piano music fills the silence";
    }

    @Override
    public Section getSection() {
        return Section.KEYBOARDS;
    }

    @Override
    String getDescription() {
        return String.format("%s-key Piano in %s %s [%sx%sx%s]",
                this.getKeys(), this.getColour(), this.getMaterial(),
                this.getWidth(), this.getHeight(), this.getDepth());
    }

    @Override
    String getShortName() {
        return String.format("%s-key Piano", this.getKeys());
    }
}
