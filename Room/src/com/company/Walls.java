package com.company;

public class Walls {
    private int numberOfWalls;
    private String colorToWalls;

    public Walls(int numberOfWalls, String colorToWalls) {
        this.numberOfWalls = numberOfWalls;
        this.colorToWalls = colorToWalls;
    }

    public int getNumberOfWalls() {
        return numberOfWalls;
    }

    public String getColorToWalls() {
        return colorToWalls;
    }
}
