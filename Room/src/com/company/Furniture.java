package com.company;

public class Furniture {
    private Wardrobe wardrobe;
    private Bed bed;
    private int tables;

    public Furniture(Wardrobe wardrobe, Bed bed, int tables) {
        this.wardrobe = wardrobe;
        this.bed = bed;
        this.tables = tables;
    }

    public Wardrobe getWardrobe() {
        return wardrobe;
    }

    public Bed getBed() {
        return bed;
    }

    public int getTables() {
        return tables;
    }
}
