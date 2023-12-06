package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.Herbivore;

public class Simulation {
    private GameMap gameMap;
    private Renderer renderer = new Renderer();
    private Action action = new Action();

    public Simulation() {
        gameMap = new GameMap(20, 20);

        action.initAction(gameMap);
        renderer.renderMap(gameMap);
    }

    public void nextTurn() {
        action.turnAction();
        renderer.renderMap(gameMap);
    }

    public void startSimulation() {
        while (GameMap.getEntityCoordinates(Herbivore.class).size() != 0) {
            nextTurn();
        }
    }

    public void pauseSimulation() {

    }
}
