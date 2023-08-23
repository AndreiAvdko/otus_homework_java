package ru.otus.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class CustomUtils {
    public static void cleanConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    public static String input(BufferedReader reader) {
        try {
            return reader.readLine().toUpperCase().strip();
        } catch (IOException e) {
            System.out.println("Ошибка ввода!!!");
        }
        return null;
    }

    public static void printMenu() {
        System.out.println("---------------------------------");
        System.out.println("--------- ГЛАВНОЕ МЕНЮ ----------");
        System.out.println("Воспользуйтесь одной из команд:");
        System.out.println("> ADD <");
        System.out.println("> LIST <");
        System.out.println("> EXIT <");
        System.out.println("---------------------------------");
    }

    public static void pressAnyKey() {
        System.out.println("-- ДЛЯ ПЕРЕХОДА В ГЛАВНОЕ МЕНЮ --");
        System.out.println("---   НАЖМИТЕ ЛЮБУЮ КЛАВИШУ   ---");
        Scanner scanner = new Scanner (System.in);
        scanner.nextLine();
        return;
    }
}