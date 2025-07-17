package org.javarush.andriy;

import java.util.Random;

public class RandomBoolean {
    public boolean getFiftyFifty() {
        Random random = new Random();
        return random.nextDouble() < 0.5;
    }
}
