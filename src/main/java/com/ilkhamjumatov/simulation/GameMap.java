package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.Entity;

import java.time.temporal.TemporalUnit;
import java.util.*;

public class GameMap {

    public static final int ROWS = 20;
    public static final int COLUMNS = 20;
    private final Map<Coordinate, Entity> entityCoordinateMap = new HashMap<>();

    public GameMap(Action action) {
        action.execute(this);
    }

    public <T extends Entity> List<Coordinate> getEntityCoordinates(Class<T> entityType) {

        List<Coordinate> result = new ArrayList<>();

        for (Map.Entry<Coordinate, Entity> entry : entityCoordinateMap.entrySet()) {

            Entity value = entry.getValue();
            Coordinate key = entry.getKey();

            if (entityType.isInstance(value)) {
                result.add(key);
            }
        }
        return result;
    }

    public <T extends Entity> List<Coordinate> getExcludingCoordinates(Class<T> entityType) {

        List<Coordinate> result = new ArrayList<>();

        for (Map.Entry<Coordinate, Entity> entry : entityCoordinateMap.entrySet()) {

            Entity value = entry.getValue();
            Coordinate key = entry.getKey();

            if (!entityType.isInstance(value)) {
                result.add(key);
            }
        }
        return result;
    }

    public void addEntity(Entity randomEntity) {
        Coordinate coordinate = randomEntity.getCoordinate();
        entityCoordinateMap.putIfAbsent(coordinate, randomEntity);
    }

    public void removeEntity(Coordinate coordinate) {
        entityCoordinateMap.remove(coordinate);
    }

    public Map<Coordinate, Entity> getEntityCoordinateMap() {
        return entityCoordinateMap;
    }

}
