package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.actions.Action;
import com.ilkhamjumatov.simulation.actions.InitAction;
import com.ilkhamjumatov.simulation.actions.TurnAction;
import com.ilkhamjumatov.simulation.entities.Herbivore;

public class Simulation {
    private final GameMap gameMap;
    private final Renderer renderer = new Renderer();
    private final Action initAction = new InitAction();
    private final Action turnAction = new TurnAction();

    public Simulation() {

        gameMap = new GameMap(initAction);
        renderer.renderMap(gameMap);
    }

    public void nextTurn() {

        turnAction.execute(gameMap);
        renderer.renderMap(gameMap);
    }

    public void startSimulation() {
        int counter = 0;
        while (gameMap.getEntityCoordinates(Herbivore.class).size() != 0) {
            nextTurn();
            System.out.println("Counter: " + ++counter);
        }
    }
}
