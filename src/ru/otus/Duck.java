package ru.otus;

public class Duck extends Animal implements Flying {
    public Duck(String name, String color, int age, int weight) {
        super(name, color, age, weight);
    }
    @Override
    public void say() {
        System.out.println("Кря");
    }
    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}
