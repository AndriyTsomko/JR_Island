package org.javarush.andriy;

import org.javarush.andriy.abstraction.entity.Animal;
import org.javarush.andriy.entity.herbivorous.*;
import org.javarush.andriy.entity.predators.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProbablyMap {

    public static final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> PROBABLY_MAP = new ConcurrentHashMap<>();

    static {
        PROBABLY_MAP.put(Wolf.class, createWolfMap());
        PROBABLY_MAP.put(Boa.class, createBoaMap());
        PROBABLY_MAP.put(Fox.class, createFoxMap());
        PROBABLY_MAP.put(Bear.class, createBearMap());
        PROBABLY_MAP.put(Eagle.class, createEagleMap());
        PROBABLY_MAP.put(Boar.class, createBoarMap());
        PROBABLY_MAP.put(Mouse.class, createMouseMap());
        PROBABLY_MAP.put(Duck.class, createDuckMap());
    }

    private static Map<Class<? extends Animal>, Integer> createWolfMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Horse.class, 10);
        map.put(Deer.class, 15);
        map.put(Rabbit.class, 60);
        map.put(Mouse.class, 80);
        map.put(Goat.class, 60);
        map.put(Sheep.class, 70);
        map.put(Boar.class, 15);
        map.put(Buffalo.class, 10);
        map.put(Duck.class, 40);
        return map;
    }

    private static Map<Class<? extends Animal>, Integer> createBoaMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Fox.class, 15);
        map.put(Rabbit.class, 20);
        map.put(Mouse.class, 40);
        map.put(Duck.class, 10);
        return map;
    }

    private static Map<Class<? extends Animal>, Integer> createFoxMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Rabbit.class, 70);
        map.put(Mouse.class, 90);
        map.put(Duck.class, 60);
        map.put(Caterpillar.class, 40);
        return map;
    }

    private static Map<Class<? extends Animal>, Integer> createBearMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Boa.class, 80);
        map.put(Horse.class, 40);
        map.put(Deer.class, 80);
        map.put(Rabbit.class, 80);
        map.put(Mouse.class, 90);
        map.put(Goat.class, 70);
        map.put(Sheep.class, 70);
        map.put(Boar.class, 50);
        map.put(Buffalo.class, 20);
        map.put(Duck.class, 10);
        return map;
    }

    private static Map<Class<? extends Animal>, Integer> createEagleMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Fox.class, 10);
        map.put(Rabbit.class, 90);
        map.put(Mouse.class, 90);
        return map;
    }

    private static Map<Class<? extends Animal>, Integer> createMouseMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Caterpillar.class, 90);
        return map;
    }

    private static Map<Class<? extends Animal>, Integer> createBoarMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Caterpillar.class, 90);
        map.put(Mouse.class, 50);
        return map;
    }

    private static Map<Class<? extends Animal>, Integer> createDuckMap() {
        Map<Class<? extends Animal>, Integer> map = new HashMap<>();
        map.put(Caterpillar.class, 90);
        return map;
    }

}