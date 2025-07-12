package org.javarush.andriy.map;

public class Island {
    private Location[][] worldMap;

    public Island(int height, int wight) {
        this.worldMap = new Location[height][wight];
        for (int i = 0; i < worldMap.length; i++) {
            for (int j = 0; j < worldMap[0].length; j++) {
                worldMap[i][j] = new Location();
            }
        }
    }

    public Location[][] getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(Location[][] worldMap) {
        this.worldMap = worldMap;
    }
}
