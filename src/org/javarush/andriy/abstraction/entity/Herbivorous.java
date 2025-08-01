package org.javarush.andriy.abstraction.entity;

import org.javarush.andriy.ProbablyMap;
import org.javarush.andriy.map.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivorous extends Animal{
    public Herbivorous(double weight, int maxNumOfSpecies, int moveSpeed, double kgOfFoodNeeds) {
        super(weight, maxNumOfSpecies, moveSpeed, kgOfFoodNeeds);
    }

    @Override
    public void eat(Location[][] map) {
        Map<Class<? extends Animal>, Integer> currentAnimalProbablyMap = ProbablyMap.PROBABLY_MAP.get(this.getClass());

        List<Organism> organismsInCurrentLocation = new ArrayList<>();
        organismsInCurrentLocation.addAll(currentLocation.getAnimals());
        organismsInCurrentLocation.addAll(currentLocation.getPlants());

        Organism victim = organismsInCurrentLocation.stream()
                .filter(organism -> !organism.equals(this) && currentAnimalProbablyMap.containsKey(organism.getClass()))
                .findAny()
                .orElse(null);

        if (victim != null) {
            double chance = (double) currentAnimalProbablyMap.get(victim.getClass()) / 100;
            if (ThreadLocalRandom.current().nextDouble() < chance) {
                if (victim instanceof Plant) {
                    currentLocation.removePlants((Plant) victim);
                } else if (victim instanceof Animal) {
                    currentLocation.removeAnimals((Animal) victim);
                }

                double percentOfNeed = this.kgOfFoodNeeds / 100;
                double gainedSatiety = victim.getWeight() * percentOfNeed;
                satiety = Math.min(100, satiety + gainedSatiety);
            }
        } else {
            super.move(map);
        }
    }
}
