package com.ilkhamjumatov.simulation.entities;

public class Herbivore extends Creature {

    public Herbivore() {
        hp = 90;
        name = "Pet";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void makeMove() {

    }
}
