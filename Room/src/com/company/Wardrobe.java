package com.company;

public class Wardrobe {
    private int numberOfClothes;
    private int jewellery;
    private Cosmetics cosmetics;

    public Wardrobe(int numberOfClothes, int jewellery, Cosmetics cosmetics) {
        this.numberOfClothes = numberOfClothes;
        this.jewellery = jewellery;
        this.cosmetics = cosmetics;
    }

    public int getNumberOfClothes() {
        return numberOfClothes;
    }

    public int getJewellery() {
        return jewellery;
    }

    public Cosmetics getCosmetics() {
        return cosmetics;
    }
}
