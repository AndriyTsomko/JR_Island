package org.javarush.andriy.abstraction.entity;
import org.javarush.andriy.map.Location;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism{
    protected double weight;
    protected int maxNumOfSpecies;
    protected int moveSpeed;
    protected double kgOfFoodNeeds;
    protected double satiety = 100.0;
    protected Location currentLocation;
    protected boolean alreadyMultiplied;
    protected static final double SATIETY_THRESHOLD = 70.0;
    protected static final double SATIETY_LOSS_PER_TICK = 5.0;

    public Animal(double weight, int maxNumOfSpecies, int moveSpeed, double kgOfFoodNeeds) {
        this.weight = weight;
        this.maxNumOfSpecies = maxNumOfSpecies;
        this.moveSpeed = moveSpeed;
        this.kgOfFoodNeeds = kgOfFoodNeeds;
    }

    public Animal createAnimal(){
        try {
            Animal animal = this.getClass().getConstructor().newInstance();
            animal.satiety = 100.0;
            animal.alreadyMultiplied = false;
            return animal;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    public void activity(Location[][] map) {
        satiety -= SATIETY_LOSS_PER_TICK;
        if (satiety <= 0){
            this.die();
            return;
        }
        boolean famine = satiety <= SATIETY_THRESHOLD;
        if (famine) {
            eat(map);
            return;
        }
        multiply();
    }

    public abstract void eat(Location[][] map);

    public void move(Location[][] map){
        int moveSpeed = ThreadLocalRandom.current().nextInt(this.getMoveSpeed() + 1);

        for (int i = 0; i < moveSpeed; i++){
            int x = currentLocation.getX();
            int y = currentLocation.getY();

            boolean moveX = ThreadLocalRandom.current().nextBoolean();
            boolean add = ThreadLocalRandom.current().nextBoolean();

            int newX = x;
            int newY = y;

            if (moveX) newX = add ? newX + 1 : newX - 1;
            else newY = add ? newY + 1 : newY - 1;

            boolean mapBorders = newY >= 0 && newY < map.length &&
                    newX >= 0 && newX < map[0].length;

            if (mapBorders){
                Location nextLocation = map[newY][newX];
                long countOfWolfInNextLocation = nextLocation.getAnimals()
                        .stream()
                        .filter(animal -> animal.getClass().equals(this.getClass()))
                        .count();

                if (countOfWolfInNextLocation < this.maxNumOfSpecies) {
                    currentLocation.removeAnimals(this);
                    this.setCurrentLocation(nextLocation);
                    nextLocation.addAnimals(this);
                }

            }
        }
    }

    public void multiply(){
        if (!alreadyMultiplied) {
            long countOfAnimalsInThisLocation = currentLocation.getAnimals()
                    .stream()
                    .filter(animal -> animal.getClass().equals(this.getClass()))
                    .count();

            if (!(countOfAnimalsInThisLocation >= this.maxNumOfSpecies)){
                List<Animal> possiblePairings = currentLocation.getAnimals()
                        .stream()
                        .filter(animal -> animal.getClass().equals(this.getClass()) && !animal.alreadyMultiplied && !animal.equals(this))
                        .toList();

                if (!possiblePairings.isEmpty()) {
                    Animal animal = possiblePairings.get(ThreadLocalRandom.current().nextInt(possiblePairings.size()));
                    animal.alreadyMultiplied = true;
                    this.alreadyMultiplied = true;
                    Animal child = createAnimal();
                    this.currentLocation.addAnimals(child);
                }

            }

        }
    }

    public void die(){
        currentLocation.removeAnimals(this);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxNumOfSpecies() {
        return maxNumOfSpecies;
    }

    public void setMaxNumOfSpecies(int maxNumOfSpecies) {
        this.maxNumOfSpecies = maxNumOfSpecies;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public double getKgOfFoodNeeds() {
        return kgOfFoodNeeds;
    }

    public void setKgOfFoodNeeds(double kgOfFoodNeeds) {
        this.kgOfFoodNeeds = kgOfFoodNeeds;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(weight, animal.weight) == 0 && maxNumOfSpecies == animal.maxNumOfSpecies && moveSpeed == animal.moveSpeed && Double.compare(kgOfFoodNeeds, animal.kgOfFoodNeeds) == 0 && Double.compare(satiety, animal.satiety) == 0 && alreadyMultiplied == animal.alreadyMultiplied && Objects.equals(currentLocation, animal.currentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, maxNumOfSpecies, moveSpeed, kgOfFoodNeeds, satiety, currentLocation, alreadyMultiplied);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", maxNumOfSpecies=" + maxNumOfSpecies +
                ", moveSpeed=" + moveSpeed +
                ", kgOfFoodNeeds=" + kgOfFoodNeeds +
                '}';
    }
}
