package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.*;

public class Renderer {

    public void renderMap(GameMap gameMap) {

        int count = 0;

        for (int i = 0; i < gameMap.getRows(); i++) {

            for (int j = 0; j < gameMap.getColumns(); j++) {

                Coordinate coordinate = new Coordinate(i, j);
                Entity entity = GameMap.entityCoordinateMap.get(coordinate);

                System.out.print(getSignOfEntity(entity));
            }
            System.out.println();
        }
        System.out.println(count);

    }

    private String getSignOfEntity(Entity entity) {

        if (entity != null) {
            return entity.toString();
        }
        return "⬛";
    }
}
