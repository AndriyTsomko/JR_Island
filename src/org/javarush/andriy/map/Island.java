package org.javarush.andriy.map;

import java.util.Arrays;
import java.util.List;

public class Island {
    private Location[][] worldMap;

    public Island(int height, int wight) {
        this.worldMap = new Location[height][wight];
        for (int i = 0; i < worldMap.length; i++){
            for (int j = 0; j < worldMap[i].length; j++){
                worldMap[i][j] = new Location(i, j);
            }
        }
    }

    public void growPlants() {
        for (Location[] row : worldMap) {
            for (Location location : row) {
                location.growPlants();
            }
        }
    }

    public List<Location> getAllLocations(){
        return Arrays.stream(worldMap).flatMap(Arrays::stream).toList();
    }
    public Location[][] getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(Location[][] worldMap) {
        this.worldMap = worldMap;
    }
}
