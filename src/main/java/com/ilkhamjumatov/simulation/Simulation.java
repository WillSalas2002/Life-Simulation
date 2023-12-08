package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.Herbivore;

public class Simulation {
    private final GameMap gameMap;
    private final Renderer renderer = new Renderer();
    private final Action[] action = {new InitAction(), new TurnAction()};

    public Simulation() {

        gameMap = new GameMap(action[0]);
        renderer.renderMap(gameMap);
    }

    public void nextTurn() {

        action[1].execute(gameMap);
        renderer.renderMap(gameMap);
    }

    public void startSimulation() {
        while (gameMap.getEntityCoordinates(Herbivore.class).size() != 0) {
            nextTurn();
        }
    }

    public void pauseSimulation() {

    }
}
