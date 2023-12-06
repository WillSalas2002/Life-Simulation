package com.ilkhamjumatov.simulation.entities;

public class Rock extends Entity {

    public Rock() {
        sing = "\uD83E\uDEA8";
    }

    @Override
    public String toString() {
        return sing;
    }
}
