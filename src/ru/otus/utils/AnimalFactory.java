package ru.otus.utils;

import ru.otus.animals.Animal;
import ru.otus.animals.Cat;
import ru.otus.animals.Dog;
import ru.otus.birds.Duck;

import java.util.Calendar;

public class AnimalFactory {

    public static Animal createAnimal(AnimalType type, String name, String color, int age, int weight) {
        switch(type) {
            case CAT: return new Cat(name, color, age, weight);
            case DOG: return new Dog(name, color, age, weight);
            case DUCK: return new Duck(name, color, age, weight);
        }
        return null;
    }
}
