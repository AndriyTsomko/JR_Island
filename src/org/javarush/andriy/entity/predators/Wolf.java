package org.javarush.andriy.entity.predators;
import org.javarush.andriy.abstraction.entity.Predator;
import org.javarush.andriy.map.Location;

public class Wolf extends Predator {
    public Wolf() {
        super(50, 30, 3, 8);
    }

    @Override
    public void eat() {

    }

    @Override
    public void move(Location[][] map) {
        super.move(map);
    }

    @Override
    public void multiply() {

    }

    @Override
    public void die() {

    }
}
