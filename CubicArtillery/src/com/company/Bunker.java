package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Martin on 12/2/2016.
 */
public class Bunker {
    private String name;
    private int bunkerCapacity;
    private ArrayList<Integer> takenCapacity = new ArrayList<>();
    private static Queue<Bunker> bunkerQueue = new LinkedList<>();

    public ArrayList<Integer> getTakenCapacity() {
        return takenCapacity;
    }

    public int getCapacity() {
        return bunkerCapacity;
    }

    public Bunker(String name, int capacity) { //ctor
        this.name = name;
        this.bunkerCapacity = capacity;
        this.bunkerQueue.offer(this);
    }

    public void takeCapacity(Bunker bunk, Weapon weapon) {
        int currentBunkCapacity = bunk.getCapacity();
        int currentWeaponCapacity = weapon.getWeaponCapacity();

        if (currentBunkCapacity > currentWeaponCapacity) {
            capacityRemove(weapon);
        } else if (currentBunkCapacity == currentWeaponCapacity) {
            capacityRemove(weapon);
            printBunker();
        } else printBunker();
    }

    private void addTakenCapacity(int capacity) {
        this.takenCapacity.add(capacity);
    }

    private void capacityRemove(Weapon weaCapacity) {
        bunkerQueue.peek().bunkerCapacity -= weaCapacity.getWeaponCapacity();
        bunkerQueue.peek().addTakenCapacity(weaCapacity.getWeaponCapacity());
        weaCapacity.pollWeapon(); // poll weapon if it has been taken
    }

    private void printBunker() {
        Bunker tmpBunk = bunkerQueue.poll();
        System.out.print(tmpBunk.name + "->");

        if (!tmpBunk.takenCapacity.isEmpty()) {
            int tmpBunkCapacity = tmpBunk.takenCapacity.size();

            for (int i = 0; i < tmpBunkCapacity; i++) {
                if (i < tmpBunkCapacity - 1)
                    System.out.print(tmpBunk.takenCapacity.get(i) + ", ");
                else
                    System.out.println(tmpBunk.takenCapacity.get(i)); //last element with no following comma and next line
            }
        } else System.out.println("Empty");
    }

    public void fillBunkers(Queue<Weapon> weapons) {
        while (!weapons.isEmpty() && !bunkerQueue.isEmpty()) {
            this.takeCapacity(bunkerQueue.peek(), weapons.peek());
        }
        if (!bunkerQueue.isEmpty()) {
            while (!bunkerQueue.isEmpty()) {
                printBunker();
            }
        }
    }
}