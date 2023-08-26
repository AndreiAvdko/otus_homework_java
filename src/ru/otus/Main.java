package ru.otus;

import ru.otus.animals.*;
import ru.otus.utils.AnimalFactory;
import ru.otus.utils.AnimalType;
import ru.otus.utils.Command;
import ru.otus.utils.CustomUtils;

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
            userInput = CustomUtils.input(reader);
            if (Command.EXIT.name().equals(userInput)) {
                break;
            }
            if (Command.LIST.name().equals(userInput)) {
                CustomUtils.cleanConsole();
                if (animals.isEmpty()) {
                    CustomUtils.cleanConsole();
                    System.out.println("Список животных пока пуст.");
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
            if (Command.ADD.name().equals(userInput)) {
                CustomUtils.cleanConsole();
                System.out.println(Command.ADD.name());
                System.out.println("Какое животное вы хотите добавить? (Введите CAT/DOG/DUCK)");
                userInput = CustomUtils.input(reader);
                if (!userInput.equals("CAT") && !userInput.equals("DOG") && !userInput.equals("DUCK")) {
                    System.out.println("Жаль, но такое животное добавить нельзя...");
                } else {
                    System.out.println("Введите имя животного:");
                    inputAnimalName = CustomUtils.input(reader);
                    System.out.println("Введите цвет животного:");
                    inputAnimalColor = CustomUtils.input(reader);
                    System.out.println("Введите возраст животного:");
                    while(true) {
                        try {
                            inputAnimalAge = Integer.parseInt(CustomUtils.input(reader));
                            if (inputAnimalAge <= 0) {
                                System.out.println("Возраст животного не может быть отрицательным или быть равен 0");
                                System.out.println("Введите возраст животного ещё раз:");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Возникли проблемы с вводом возраста животного.");
                            System.out.println("Попробуйте ещё раз:");
                        }
                    }
                    System.out.println("Введите вес животного:");
                    while (true) {
                        try {
                            inputAnimalWeight = Integer.parseInt(CustomUtils.input(reader));
                            if(inputAnimalWeight <= 0) {
                                System.out.println("Вес животного не может быть отрицательным или быть равен 0");
                                System.out.println("Введите вес животного ещё раз:");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Возникли проблемы с вводом веса животного.");
                            System.out.println("Попробуйте ещё раз:");
                        }
                    }
                    CustomUtils.cleanConsole();
                    System.out.println("Животное типа " + userInput + " было добавлено в список животных");
                    animals.add(AnimalFactory.createAnimal(AnimalType.valueOf(userInput), inputAnimalName, inputAnimalColor, inputAnimalAge, inputAnimalWeight));
                    System.out.print("Вызов метода say() ---> ");
                    animals.get(animals.size()-1).say();
                    CustomUtils.pressAnyKey();
                }
            }
        }
    }
}
