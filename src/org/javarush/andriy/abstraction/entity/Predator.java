package org.javarush.andriy.abstraction.entity;

public abstract class Predator extends Animal {
    public Predator(double weight, int maxNumOfSpecies, int moveSpeed, double kgOfFoodNeeds) {
        super(weight, maxNumOfSpecies, moveSpeed, kgOfFoodNeeds);
    }
}
