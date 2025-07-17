package org.javarush.andriy.runner;

import org.javarush.andriy.cli.CLIService;
import org.javarush.andriy.island_creator.IslandCreator;
import org.javarush.andriy.map.Island;
import org.javarush.andriy.map.Location;

public class IslandRunner {
    public void startSimulation(){
        CLIService cliService = new CLIService();
        int height = cliService.enterHeight();
        int weight = cliService.enterWeight();
        Island island = new Island(height, weight);
        new IslandCreator().generateIsland(island);
        showArray(island);
        showOrganism(island);
    }

    private void showArray(Island island) {
        for (Location[] locations : island.getWorldMap()) {
            for (Location location : locations) {
                System.out.print(location+ " ");
            }
            System.out.println();
        }
    }

    private void showOrganism(Island island){
        for (Location[] locations : island.getWorldMap()) {
            for (Location location : locations){
                System.out.printf("На локації з координатами x=%d; y=%d було створено %d Plants\n",location.getX(), location.getY(),location.getPlants().size());
                System.out.printf("Було створено %d Animals\n", location.getAnimals().size());
            }
        }

    }
}
