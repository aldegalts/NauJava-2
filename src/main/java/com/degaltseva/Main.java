package com.degaltseva;

import com.degaltseva.task1.Task1;
import com.degaltseva.task2.Task2;
import com.degaltseva.task3.Task3;
import com.degaltseva.task4.Task4;
import com.degaltseva.task5.Task5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Выберите задание (1–5): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    Task1 task = new Task1();
                    task.run();
                }
                case 2 -> {
                    Task2 task = new Task2();
                    task.run();
                }
                case 3 -> {
                    Task3 task = new Task3();
                    task.run();
                }
                case 4 -> {
                    Task4 task = new Task4();
                    task.run();
                }
                case 5 -> {
                    Task5 task5 = new Task5(5);
                    task5.run();
                }
                case 6 -> {
                    List<MyRunnable> list = List.of(
                            new Task1(),
                            new Task2(),
                            new Task3(),
                            new Task4(),
                            new Task5(5)
                    );
                    list.forEach(MyRunnable::run);
                }
                default -> System.out.println("Неверный выбор.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: введено некорректное значение. Пожалуйста, введите число от 1 до 6.");
        } catch (Exception e) {
            System.err.println("Произошла ошибка при выполнении задачи: " + e.getMessage());
        }
    }
}
