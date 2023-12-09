package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.*;

public class Renderer {

    public void renderMap(GameMap gameMap) {

        for (int i = 0; i < GameMap.ROWS; i++) {

            for (int j = 0; j < GameMap.COLUMNS; j++) {

                Coordinate coordinate = new Coordinate(i, j);
                Entity entity = gameMap.getEntityCoordinateMap().get(coordinate);

                System.out.print(getSignOfEntity(entity));
            }
            System.out.println();
        }
        System.out.println("============================================");
    }

    private String getSignOfEntity(Entity entity) {

        if (entity != null) {
            return entity.toString();
        }
        return "⬛";
    }
}
