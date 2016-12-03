package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Martin on 12/2/2016.
 */
public class Weapon {

    private int weaponCapacity;
    private static Queue<Weapon> weaponQueue =new LinkedList<>();

    public static Queue<Weapon> getWeaponQueue() {
        return weaponQueue;
    }

    public int getWeaponCapacity() {
        return weaponCapacity;
    }

    public Weapon(int weaponCapacity) {
        this.weaponCapacity = weaponCapacity;
        this.weaponQueue.offer(this);
    }

    public void pollWeapon(){
        this.weaponQueue.poll();
    }
}
