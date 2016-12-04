package com.company;

import java.util.ArrayList;

/**
 * Created by Martin on 12/2/2016.
 */
public class Bunker {
    private String name;
    private int capacity;
    private ArrayList<Integer> takenCapacity = new ArrayList<>();

    public Bunker(String name, int capacity) { //ctor
        this.name = name;
        this.capacity = capacity;
    }

    public boolean addToCapacity(int capacity) {
        if(this.capacity>= capacity) {
            this.takenCapacity.add(capacity);
            this.capacity-=capacity;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "->");
        if(this.takenCapacity.isEmpty()){
            sb.append("Empty");
        }else{
            for (Integer takenCapacity : this.takenCapacity) {
                sb.append(takenCapacity + ", ");
            }

        }
        return sb.toString();
    }
}