package ru.otus;

public class Animal {
    private String name;
    private String color;
    private int age;
    private int weight;

    public Animal(String name, String color, int age, int weight) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight;
    }

    public void say() {
        System.out.println("Я говорю");
    }
    public void go() {
        System.out.println("Я иду");
    }
    public void drink() {
        System.out.println("Я пью");
    }
    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        String yearsStr = "";
        int ageLastNumber = this.age % 10;
        boolean isExclusion = (this.age % 100 >= 11) && (this.age % 100 <= 14);
        if (ageLastNumber == 1)
            yearsStr = " год, ";
        else if(ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
            yearsStr = " лет, ";
        else if(ageLastNumber >= 2 && ageLastNumber <= 4)
            yearsStr = " года, ";
        if (isExclusion)
            yearsStr = " лет, ";
        return "Привет! Меня зовут " + this.name + ", мне " + this.age + yearsStr +
                "я вешу - " + this.weight + " кг, мой цвет - " + this.color;
    }
}
