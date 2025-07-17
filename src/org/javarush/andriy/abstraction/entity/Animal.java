package org.javarush.andriy.abstraction.entity;
import org.javarush.andriy.map.Location;

import java.util.Random;

public abstract class Animal {
    protected double weight;
    protected int maxNumOfSpecies;
    protected int moveSpeed;
    protected double kgOfFoodNeeds;
    protected Location currentLocation;

    public Animal(double weight, int maxNumOfSpecies, int moveSpeed, double kgOfFoodNeeds) {
        this.weight = weight;
        this.maxNumOfSpecies = maxNumOfSpecies;
        this.moveSpeed = moveSpeed;
        this.kgOfFoodNeeds = kgOfFoodNeeds;
    }

    public abstract void eat();

    public void move(Location[][] map){
        Random random = new Random();
        int moveSpeed = random.nextInt(this.getMoveSpeed() + 1);

        for (int i = 0; i < moveSpeed; i++){
            int x = currentLocation.getX();
            int y = currentLocation.getY();

            boolean moveX = random.nextBoolean();
            boolean add = random.nextBoolean();

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

                if (countOfWolfInNextLocation < this.getMaxNumOfSpecies()) {
                    currentLocation.removeAnimals(this);
                    this.setCurrentLocation(nextLocation);
                    nextLocation.addAnimals(this);
                }

            }
        }
    }

    public abstract void multiply();

    public abstract void die();

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
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", maxNumOfSpecies=" + maxNumOfSpecies +
                ", moveSpeed=" + moveSpeed +
                ", kgOfFoodNeeds=" + kgOfFoodNeeds +
                '}';
    }
}
