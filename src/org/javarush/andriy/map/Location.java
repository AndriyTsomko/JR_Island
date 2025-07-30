package org.javarush.andriy.map;

import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.abstraction.entity.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
    private final List<Animal> animals = Collections.synchronizedList(new ArrayList<>());
    private final List<Plant> plants = Collections.synchronizedList(new ArrayList<>());
    private final int x;
    private final int y;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public synchronized void growPlants() {
        int countOfPlants = plants.size();
        if (countOfPlants < Plant.maxNumOfSpecies) {
            int toGrow = ThreadLocalRandom.current().nextInt(2);
            for (int i = 0; i < toGrow && plants.size() < Plant.maxNumOfSpecies; i++) {
                addPlants(new Plant());
            }
        }
    }

    public synchronized void addAnimals(Animal animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
            animal.setCurrentLocation(this);
        }
    }

    public synchronized void addPlants(Plant plant) {
        if (!plants.contains(plant)) {
            plants.add(plant);
        }
    }

    public synchronized void removeAnimals(Animal animal) {
        if (animals.contains(animal)) {
            animals.remove(animal);
            animal.setCurrentLocation(null);
        }
    }

    public synchronized void removePlants(Plant plant) {
        if (plants.contains(plant)) {
            plants.remove(plant);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
