package com.degaltseva.task2;

import java.util.*;

public class Task2 {

    public static void startTask2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов списка: ");
        int n = scanner.nextInt();

        ArrayList<Double> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextDouble() * 100);
        }

        System.out.println("Исходный список:");
        System.out.println(list);

        list = mergeSort(list);

        System.out.println("Отсортированный список:");
        System.out.println(list);
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
}

