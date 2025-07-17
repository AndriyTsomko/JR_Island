package org.javarush.andriy.map;

import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.abstraction.entity.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();
    private final int x;
    private final int y;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public synchronized void addAnimals(Animal animal){
        animals.add(animal);
        animal.setCurrentLocation(this);
    }

    public synchronized void addPlants(Plant plant){
        plants.add(plant);
    }

    public synchronized void removeAnimals(Animal animal){
        animals.remove(animal);
    }

    public synchronized void removePlants(Plant plant){
        plants.remove(plant);
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
