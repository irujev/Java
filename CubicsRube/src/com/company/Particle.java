package com.company;

import java.util.ArrayList;

/**
 * Created by Martin on 12/3/2016.
 */
public class Particle {

    private int x;
    private int y;
    private int z;
    private int power;
    private static int totalPower;
    private static int validCells;

    public static ArrayList<Particle> getParticleList() {
        return particleList;
    }

    private static ArrayList<Particle> particleList=new ArrayList<>();

    public static int getTotalPower() {
        return totalPower;
    }

    public static int getValidCells() {
        return validCells;
    }

    public Particle(int x, int y, int z, int power) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.power = power;
        particleList.add(this);
    }

    private int[][][] bombardCell(int[][][] cube ) {
        int x,y,z,cubeLength;
        x=this.x;
        y=this.y;
        z=this.z;
        cubeLength=cube.length;

        if (x<cubeLength && y<cubeLength && z<cubeLength && x>=0 && y>=0 && z>=0 && cube[x][y][z]==0){
            cube[x][y][z]=power;
            this.totalPower+=power;
            this.validCells++;
        }

        return cube;
    }

    public static int[][][] startBombard(int[][][] cube){
        for (int i=0;i<getParticleList().size();i++){
            cube=getParticleList().get(i).bombardCell(cube);
        }
        return cube;
    }

}
