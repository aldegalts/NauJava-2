package com.degaltseva.task1;

import com.degaltseva.MyRunnable;

import java.util.Random;
import java.util.Scanner;

public class Task1 implements MyRunnable {

    @Override
    public void run() {
        int n = getN();

        int[] arr = createArray(n);
        printArray(arr);

        int maxAbs = findMaxAbs(n, arr);
        showResult(maxAbs);
    }

    private int getN() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        return scanner.nextInt();
    }

    private int[] createArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(201) - 100;
        }
        return arr;
    }

    private void printArray(int[] arr) {
        System.out.print("Массив: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    private int findMaxAbs(int n, int[] arr) {
        int maxAbs = Math.abs(arr[0]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i]) > maxAbs) {
                maxAbs = Math.abs(arr[i]);
            }
        }
        return maxAbs;
    }

    private void showResult(int maxAbs) {
        System.out.println("\nМаксимальное значение по модулю: " + maxAbs);
    }
}
