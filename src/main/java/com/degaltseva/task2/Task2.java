package com.degaltseva.task2;

import com.degaltseva.MyRunnable;

import java.util.*;

public class Task2 implements MyRunnable {

    @Override
    public void run() {
        int n = getN();

        ArrayList<Double> list = createList(n);
        printList(list);

        list = mergeSort(list);
        showResult(list);
    }

    public static ArrayList<Double> mergeSort(ArrayList<Double> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        ArrayList<Double> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Double> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static ArrayList<Double> merge(ArrayList<Double> left, ArrayList<Double> right) {
        ArrayList<Double> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }

    private int getN() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов списка: ");
        return scanner.nextInt();
    }

    private ArrayList<Double> createList(int n) {
        ArrayList<Double> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextDouble() * 100);
        }
        return list;
    }

    private void printList(ArrayList<Double> list) {
        System.out.println("Исходный список:");
        System.out.println(list);
    }

    private void showResult(ArrayList<Double> list) {
        System.out.println("Отсортированный список:");
        System.out.println(list);
    }
}

