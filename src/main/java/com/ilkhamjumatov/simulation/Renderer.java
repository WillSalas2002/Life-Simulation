package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.*;

public class Renderer {

    public void renderMap(GameMap gameMap) {

        int count = 0;

        for (int i = 0; i < gameMap.getRows(); i++) {

            for (int j = 0; j < gameMap.getColumns(); j++) {

                Coordinate coordinate = new Coordinate(i, j);
                Entity entity = GameMap.entityCoordinateMap.get(coordinate);
                if (entity != null) {
                    count++;
                }

                System.out.print(getLabelOfEachEntity(entity));
            }
            System.out.println();
        }
        System.out.println(count);

    }

    private String getLabelOfEachEntity(Entity entity) {

        if (entity instanceof Grass) {
            return "\uD83C\uDF3F";
        } else if (entity instanceof Predator) {
            return "\uD83E\uDD81";
        } else if (entity instanceof Herbivore) {
            return "\uD83D\uDC11";
        } else if (entity instanceof Rock) {
            return "\uD83E\uDEA8";
        } else if (entity instanceof Tree) {
            return "\uD83C\uDF33";
        }

        return "⬛";
    }

}
