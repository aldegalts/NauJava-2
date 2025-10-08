package com.degaltseva.task1;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(201) - 100;
        }

        System.out.print("Массив: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        int maxAbs = Math.abs(arr[0]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i]) > maxAbs) {
                maxAbs = Math.abs(arr[i]);
            }
        }

        System.out.println("\nМаксимальное значение по модулю: " + maxAbs);
    }
}
