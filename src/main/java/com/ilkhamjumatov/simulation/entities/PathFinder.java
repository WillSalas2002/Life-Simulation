package com.ilkhamjumatov.simulation.entities;

import com.ilkhamjumatov.simulation.Coordinate;
import com.ilkhamjumatov.simulation.GameMap;

import java.util.*;
public class PathFinder {

    public static List<Coordinate> breadthFirstSearch(Coordinate source, List<Coordinate> targets, List<Coordinate> exclude) {

        Queue<LinkedList<Coordinate>> queue = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        LinkedList<Coordinate> path = new LinkedList<>();

        path.offer(source);
        queue.add(path);
        visited.add(source);

        while (!queue.isEmpty()) {
            LinkedList<Coordinate> currentPath = queue.poll();
            Coordinate currentCoordinate = currentPath.getLast();

            if (targets.contains(currentCoordinate)) {
                currentPath.removeFirst();
                return currentPath;
            }

            // Получаем соседние координаты текущей координаты
            // Для каждой соседней координаты
            Set<Coordinate> neighboringCells = getNeighbours(currentCoordinate, exclude);
            for (Coordinate neighborCoordinate : neighboringCells) {
                if (!visited.contains(neighborCoordinate)) {

                    LinkedList<Coordinate> newPath = new LinkedList<>(currentPath); // Создаем новый путь
                    newPath.add(neighborCoordinate); // Добавляем соседнюю координату в путь

                    queue.offer(newPath); // Добавляем новый путь в очередь
                    visited.add(neighborCoordinate); // Помечаем соседнюю координату как посещенную
                }
            }
        }

        return null; // Если путь не найден, возвращаем null
    }

    private static Set<Coordinate> getNeighbours(Coordinate coordinate, List<Coordinate> exclude) {

        Set<Coordinate> coordinateSet = new HashSet<>();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                Coordinate offer = new Coordinate(coordinate.getX() + i, coordinate.getY() + j);

                if (offer.getX() >= 10 || offer.getX() < 0) {
                    continue;
                }

                if (offer.getY() >= 10 || offer.getY() < 0) {
                    continue;
                }

                if (exclude.contains(offer)) {
                    continue;
                }

                coordinateSet.add(offer);
            }
        }

        return coordinateSet;
    }
}
