package org.javarush.andriy.island_creator;

import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.abstraction.entity.Plant;
import org.javarush.andriy.entity.herbivorous.*;
import org.javarush.andriy.entity.predators.*;
import org.javarush.andriy.map.Island;
import org.javarush.andriy.map.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IslandCreator {
    private final List<Animal> animals = new ArrayList<>(List.of(new Boar(), new Buffalo(), new Caterpillar(), new Deer(),
            new Duck(), new Goat(), new Horse(), new Mouse(), new Rabbit(), new Sheep(), new Bear(), new Boa(), new Eagle(),
            new Fox(), new Wolf()));

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
        int countsOfPlants = random.nextInt(Plant.maxNumOfSpecies);
        for (int i = 0; i < countsOfPlants; i++){
            location.addPlants(new Plant());
        }

        for(Animal animal : animals){
            for (int i = 0; i < random.nextInt(animal.getMaxNumOfSpecies()); i++){
                location.addAnimals(animal.createAnimal());
            }
        }
    }
}
