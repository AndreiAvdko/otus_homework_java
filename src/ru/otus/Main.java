package ru.otus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String userInput = "";
        String inputAnimalName = "";
        String inputAnimalColor = "";
        int inputAnimalAge = 0;
        int inputAnimalWeight = 0;
        ArrayList <Animal> animals = new ArrayList<Animal>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            CustomUtils.cleanConsole();
            CustomUtils.printMenu();
            userInput = reader.readLine().toUpperCase().strip();
            if (Command.EXIT.toString().equals(userInput)) {
                break;
            }
            if (Command.LIST.toString().equals(userInput)) {
                CustomUtils.cleanConsole();
                if (animals.isEmpty()) {
                    System.out.println("Список животных пока пуст.");
                    CustomUtils.pressAnyKey();
                    CustomUtils.cleanConsole();
                } else {
                    System.out.println("---------------------------------");
                    System.out.println("Методы say() из списка животных: ");
                }
                for (Animal animal : animals) {
                    animal.say();
                }
                System.out.println("---------------------------------");
                CustomUtils.pressAnyKey();
            }
            if (Command.ADD.toString().equals(userInput)) {
                CustomUtils.cleanConsole();
                System.out.println(Command.ADD.toString());
                System.out.println("Какое животное вы хотите добавить? (Введите CAT/DOG/DUCK)");
                userInput = reader.readLine().toUpperCase().strip();
                if (!userInput.equals("CAT") && !userInput.equals("DOG") && !userInput.equals("DUCK")) {
                    System.out.println("Жаль, но такое животное добавить нельзя...");
                } else {
                    System.out.println("Введите имя животного:");
                    inputAnimalName = reader.readLine();
                    System.out.println("Введите цвет животного:");
                    inputAnimalColor = reader.readLine();
                    System.out.println("Введите возраст животного:");
                    while(true) {
                        try {
                            inputAnimalAge = Integer.parseInt(reader.readLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Возникли проблемы с вводом возраста животного.");
                            System.out.println("Попробуйте ещё раз:");
                        }
                    }
                    System.out.println("Введите вес животного:");
                    while (true) {
                        try {
                            inputAnimalWeight = Integer.parseInt(reader.readLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Возникли проблемы с вводом веса животного.");
                            System.out.println("Попробуйте ещё раз:");
                        }
                    }
                    switch (userInput) {
                        case "CAT": CustomUtils.cleanConsole();
                                    System.out.println("Кот был добавлен в список животных");
                                    animals.add(new Cat(inputAnimalName, inputAnimalColor, inputAnimalAge, inputAnimalWeight));
                                    System.out.print("Вызов метода say() ---> ");
                                    animals.get(animals.size()-1).say();
                                    CustomUtils.pressAnyKey();
                                    break;
                        case "DOG": CustomUtils.cleanConsole();
                                    System.out.println("Пес был добавлен в список животных");
                                    animals.add(new Dog(inputAnimalName, inputAnimalColor, inputAnimalAge, inputAnimalWeight));
                                    System.out.print("Вызов метода say() ---> ");
                                    animals.get(animals.size()-1).say();
                                    CustomUtils.pressAnyKey();
                                    break;
                        case "DUCK": CustomUtils.cleanConsole();
                                     System.out.println("Утка была добавлена в список животных");
                                     animals.add(new Duck(inputAnimalName, inputAnimalColor, inputAnimalAge, inputAnimalWeight));
                                     System.out.print("Вызов метода say() ---> ");
                                     animals.get(animals.size()-1).say();
                                     CustomUtils.pressAnyKey();
                                     break;
                    }
                }
            }
        }
    }
}
