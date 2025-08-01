package org.javarush.andriy.abstraction.entity;

import org.javarush.andriy.ProbablyMap;
import org.javarush.andriy.map.Location;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public Predator(double weight, int maxNumOfSpecies, int moveSpeed, double kgOfFoodNeeds) {
        super(weight, maxNumOfSpecies, moveSpeed, kgOfFoodNeeds);
    }

    @Override
    public void eat(Location[][] map) {
        Map<Class<? extends Animal>, Integer> currentAnimalProbablyMap = ProbablyMap.PROBABLY_MAP.get(this.getClass());
        List<Animal> animalsInCurrentLocation = getCurrentLocation().getAnimals();

        Animal victim = animalsInCurrentLocation.stream()
                .filter(animal -> !animal.equals(this) && currentAnimalProbablyMap.containsKey(animal.getClass()))
                .findAny()
                .orElse(null);

        if (victim != null) {
            double chance = (double) currentAnimalProbablyMap.get(victim.getClass()) / 100;
            if (ThreadLocalRandom.current().nextDouble() < chance
                    && currentLocation.getAnimals().contains(victim)) {
                currentLocation.removeAnimals(victim);
                double percentOfNeed = this.kgOfFoodNeeds / 100;
                double gainedSatiety = victim.weight * percentOfNeed;
                satiety = Math.min(100, satiety + gainedSatiety);

            }
        } else {
            super.move(map);
        }

    }

}
