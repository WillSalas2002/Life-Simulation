package com.ilkhamjumatov.simulation.entities;

public class Predator extends Creature {

    private final int powerOfAttack;
    public Predator() {
        name = "Lion";
        powerOfAttack = 30;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void makeMove() {

    }
}
