package com.company;

public class Main { // Test Class - change values

    public static void main(String[] args) {
        Bunker a = new Bunker("a",25);
        Bunker b = new Bunker("b",20);
        Bunker c = new Bunker("c",30);

        Weapon w1=new Weapon(10);
        Weapon w2=new Weapon(20);
        Weapon w3=new Weapon(1);
        Weapon w4=new Weapon(20);

        a.fillBunkers(Weapon.getWeaponQueue());
    }
}
