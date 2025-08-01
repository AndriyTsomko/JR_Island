package org.javarush.andriy.abstraction.entity;

public class Plant extends Organism{
    public static final double weight = 1;
    public static final int maxNumOfSpecies = 200;

    @Override
    public double getWeight() {
        return weight;
    }
}
