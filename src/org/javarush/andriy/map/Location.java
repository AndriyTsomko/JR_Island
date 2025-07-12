package org.javarush.andriy.map;

import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.abstraction.entity.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    public synchronized void addAnimals(Animal animal){
        animals.add(animal);
    }

    public synchronized void addPlants(Plant plant){
        plants.add(plant);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}
