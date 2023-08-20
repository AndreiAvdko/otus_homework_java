package ru.otus;

public class Cat extends Animal{
    public Cat(String name, String color, int age, int weight) {
        super(name, color, age, weight);
    }
    @Override
    public void say() {
        System.out.println("Мяу");;
    }
}
