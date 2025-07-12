package org.javarush.andriy.abstraction.entity;

public abstract class Herbivorous extends Animal{
    public Herbivorous(double weight, int maxNumOfSpecies, int moveSpeed, double kgOfFoodNeeds) {
        super(weight, maxNumOfSpecies, moveSpeed, kgOfFoodNeeds);
    }
}
