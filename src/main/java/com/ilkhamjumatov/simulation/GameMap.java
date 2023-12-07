package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.Entity;

import java.time.temporal.TemporalUnit;
import java.util.*;

public class GameMap {

    private final int rows;
    private final int columns;
    private final Map<Coordinate, Entity> entityCoordinateMap = new HashMap<>();

    public GameMap(int rows, int columns, Action action) {
        this.rows = rows;
        this.columns = columns;
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
        entityCoordinateMap.put(coordinate, randomEntity);
    }

    public void removeEntity(Coordinate coordinate) {
        entityCoordinateMap.remove(coordinate);
    }

    public Map<Coordinate, Entity> getEntityCoordinateMap() {
        return entityCoordinateMap;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
