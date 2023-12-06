package com.ilkhamjumatov.simulation.entities;

import com.ilkhamjumatov.simulation.Coordinate;

public abstract class Creature extends Entity {

    protected PathFinder pathFinder;
    protected int hp;

    public abstract void makeMove(Coordinate coordinate);

}
