package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main { // Test Class - change values

    public static void main(String[] args) {
        List<Bunker> bunkerList = new LinkedList<>();
        Queue<Weapon> weaponQueue = new LinkedList<>();
        bunkerList.add(new Bunker("bunker 1",25));
        bunkerList.add(new Bunker("bunker 2",20));
        bunkerList.add(new Bunker("bunker 3",30));

        weaponQueue.offer(new Weapon(10));
        weaponQueue.offer(new Weapon(20));
        weaponQueue.offer(new Weapon(1));
        weaponQueue.offer(new Weapon(20));
        weaponQueue.offer(new Weapon(5));
        weaponQueue.offer(new Weapon(20));
        weaponQueue.offer(new Weapon(20));

        fillBunkersWithWeapons(weaponQueue, bunkerList);
        bunkerList.forEach(System.out::println);
    }

    private static void fillBunkersWithWeapons(Queue<Weapon> weaponQueue, List<Bunker> bunkers) {
        Iterator<Bunker> iterator = bunkers.iterator();
        Bunker bunker = iterator.next();
        while (!weaponQueue.isEmpty()) {
            boolean isAdded = bunker.addToCapacity(weaponQueue.peek().getCapacity());
            if(isAdded){
                weaponQueue.poll();
            }else {
                if (iterator.hasNext()) {
                    bunker = iterator.next();
                }else
                    break;
            }
        }
    }
}