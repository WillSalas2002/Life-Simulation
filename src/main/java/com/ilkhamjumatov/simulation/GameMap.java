package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.Entity;
import com.ilkhamjumatov.simulation.entities.Grass;
import com.ilkhamjumatov.simulation.entities.Herbivore;

import java.util.*;

public class GameMap {

    private int rows;
    private int columns;
    private Action action = new Action();
    public static Map<Coordinate, Entity> entityCoordinateMap = new HashMap<>();

    public GameMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        action.initAction(this);
    }

    public static List<Coordinate> excludingGrass() {

        List<Coordinate> result = new ArrayList<>();

        for (Map.Entry<Coordinate, Entity> entry : entityCoordinateMap.entrySet()) {

            Entity value = entry.getValue();
            Coordinate key = entry.getKey();

            if (!(value instanceof Grass)) {
                result.add(key);
            }
        }
        return result;
    }

    public static List<Coordinate> getGrassCoordinate() {
        List<Coordinate> result = new ArrayList<>();

        for (Map.Entry<Coordinate, Entity> entry : entityCoordinateMap.entrySet()) {

            Entity value = entry.getValue();
            Coordinate key = entry.getKey();

            if (value instanceof Grass) {
                result.add(key);
            }
        }
        return result;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
