package org.javarush.andriy.island_creator;

import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.abstraction.entity.Plant;
import org.javarush.andriy.entity.herbivorous.Sheep;
import org.javarush.andriy.entity.predators.Wolf;
import org.javarush.andriy.map.Island;
import org.javarush.andriy.map.Location;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class IslandCreator {
    private final List<Animal> animals = new ArrayList<>(List.of(new Wolf(), new Sheep()));

    public void generateIsland(Island island){
        Location[][] worldMap = island.getWorldMap();

        for (Location[] row : worldMap){
            for (Location location : row){
                generateLocation(location);
            }
        }
        island.setWorldMap(worldMap);
    }

    private void generateLocation(Location location){
        Random random = new Random();
        int countsOfPlants = random.nextInt(Plant.maxNumOfSpecies / 3);
        for (int i = 0; i < countsOfPlants; i++){
            location.addPlants(new Plant());
        }

        int numberOfAnimalSpecies = random.nextInt(animals.size());
        HashSet<Animal> animalsSet = new HashSet<>();
        for (int i = 0; i < numberOfAnimalSpecies; i++) {
            animalsSet.add(animals.get(random.nextInt(animals.size())));
        }

        for(Animal animal : animalsSet){
            for (int i = 0; i < random.nextInt(animal.getMaxNumOfSpecies() / 3); i++){
                location.addAnimals(animal);
            }
        }
    }
}
