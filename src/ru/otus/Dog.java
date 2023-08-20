package ru.otus;

public class Dog extends Animal {
    public Dog(String name, String color, int age, int weight) {
        super(name, color, age, weight);
    }
    @Override
    public void say() {
        System.out.println("Гав");
    }
}
