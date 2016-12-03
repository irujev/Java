package com.company;

public class Main {

    public static void main(String[] args) {

        final int SIZE = 5;
        int[][][] cube = new int[SIZE][SIZE][SIZE];

        Particle p1 = new Particle(3, 2, 3, 10);
        Particle p2 = new Particle(-1, -1, -1, 0);
        Particle p3 = new Particle(1, 4, 0, 20);
        Particle p4 = new Particle(2, 2, 2, 5);

        Particle.startBombard(cube);

        System.out.println(Particle.getTotalPower());

        int totalCells=(int)Math.pow(SIZE,3.0);

        System.out.println(totalCells-Particle.getValidCells());
    }
}
