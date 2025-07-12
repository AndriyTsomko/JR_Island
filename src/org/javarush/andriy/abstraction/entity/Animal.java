package org.javarush.andriy.abstraction.entity;

public abstract class Animal {
    protected double weight;
    protected int maxNumOfSpecies;
    protected int moveSpeed;
    protected double kgOfFoodNeeds;

    public Animal(double weight, int maxNumOfSpecies, int moveSpeed, double kgOfFoodNeeds) {
        this.weight = weight;
        this.maxNumOfSpecies = maxNumOfSpecies;
        this.moveSpeed = moveSpeed;
        this.kgOfFoodNeeds = kgOfFoodNeeds;
    }

    public abstract void eat();

    public abstract void move();

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
