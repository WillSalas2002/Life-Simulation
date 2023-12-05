package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.Entity;

import java.util.HashMap;
import java.util.Map;

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
