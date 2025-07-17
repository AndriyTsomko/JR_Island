package org.javarush.andriy.entity.herbivorous;

import org.javarush.andriy.abstraction.entity.Herbivorous;
import org.javarush.andriy.map.Location;

public class Sheep extends Herbivorous {
    public Sheep() {
        super(70, 140, 3, 15);
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
