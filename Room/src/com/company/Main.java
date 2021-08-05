package com.company;

public class Main {

    public static void main(String[] args) {
        Walls walls =new Walls(4,"Blue");
        Wardrobe wardrobe = new Wardrobe(12,5,new Cosmetics("Loreal",10));
        Bed bed =new Bed(2,"Extra soft");
        Furniture furniture = new Furniture(wardrobe, bed, 2);
        Cosmetics cosmetics = new Cosmetics("Makeitup", 3);

        Room siddhuRoom = new Room(walls,furniture);
        System.out.println(siddhuRoom.getFurniture().getWardrobe().getCosmetics().hiding());
    }
}
