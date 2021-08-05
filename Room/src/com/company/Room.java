package com.company;

public class Room {
    private Walls walls;
    private Furniture furniture;

    public Room(Walls walls, Furniture furniture) {
        this.walls = walls;
        this.furniture = furniture;
    }

    public Walls getWalls() {
        return walls;
    }

    public Furniture getFurniture() {
        return furniture;
    }
}
