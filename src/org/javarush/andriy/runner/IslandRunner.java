package org.javarush.andriy.runner;

import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.cli.CLIService;
import org.javarush.andriy.island_creator.IslandCreator;
import org.javarush.andriy.map.Island;
import org.javarush.andriy.map.Location;
import org.javarush.andriy.statistics.PopulationPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IslandRunner {
    public void startSimulation() {
        CLIService cliService = new CLIService();
        cliService.welcome();
        int height = cliService.enterHeight();
        int weight = cliService.enterWidth();

        Island island = new Island(height, weight);
        new IslandCreator().generateIsland(island);
        runCycle(island);
    }

    private void runCycle(Island island) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        while(checkingAbsenceOfOrganisms(island)) {
            List<Callable<Void>> tasks = new ArrayList<>();
            for (Location location : island.getAllLocations()) {
                tasks.add(() -> {
                    for (Animal animal : new ArrayList<>(location.getAnimals())) {
                        animal.activity(island.getWorldMap());
                    }
                    return null;
                });
            }

            try {
                executor.invokeAll(tasks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            island.growPlants();

            PopulationPrinter.print(island);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        executor.shutdown();
    }

    private boolean checkingAbsenceOfOrganisms(Island island){
        List<Location> allLocations = island.getAllLocations();
        for (Location location : allLocations){
            if (!location.getAnimals().isEmpty()){
                return true;
            }
        }
        return false;
    }

}
