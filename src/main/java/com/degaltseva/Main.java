package com.degaltseva;

import com.degaltseva.task1.Task1;
import com.degaltseva.task2.Task2;
import com.degaltseva.task3.Task3;
import com.degaltseva.task4.Task4;
import com.degaltseva.task5.Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите задание (1–5): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> Task1.startTask1();
            case 2 -> Task2.startTask2();
            case 3 -> Task3.startTask3();
            case 4 -> Task4.startTask4();
            case 5 -> {
                Task5 timer = new Task5(5);
                timer.start();
                try {
                    Thread.sleep(3000);
                    timer.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            default -> System.out.println("Неверный выбор.");
        }
    }
}
