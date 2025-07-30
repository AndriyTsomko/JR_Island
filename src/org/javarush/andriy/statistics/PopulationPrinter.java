package org.javarush.andriy.statistics;

import org.javarush.andriy.map.Island;
import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.map.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopulationPrinter {
    private static final String RED = "\u001b[31m";
    private static final String GREEN = "\u001b[32m";
    private static final String YELLOW = "\u001b[33m";
    private static final String BLUE = "\u001b[34m";
    private static final String PURPLE = "\u001b[35m";
    private static final String CYAN = "\u001b[36m";
    private static final String WHITE = "\u001b[37m";

    public static void print(Island island) {
        Map<String, Integer> animalCounts = new HashMap<>();
        int totalPlants = 0;

        for (Location location : island.getAllLocations()) {
            List<Animal> animals = location.getAnimals();
            for (Animal animal : animals) {
                String name = animal.getClass().getSimpleName();
                animalCounts.put(name, animalCounts.getOrDefault(name, 0) + 1);
            }

            totalPlants += location.getPlants().size();
        }

        System.out.println(RED + "=== CURRENT POPULATION ===");
        System.out.println(CYAN + "--- Animals ---");
        animalCounts.forEach((name, count) -> System.out.printf(CYAN + "%-10s: %d%n", name, count));
        System.out.println(GREEN + "--- Plants ---");
        System.out.printf(GREEN + "Plant     : %d%n", totalPlants);
        System.out.println(RED + "==========================\n");
    }
}
