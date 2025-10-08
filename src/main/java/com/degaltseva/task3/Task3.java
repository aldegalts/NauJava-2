package com.degaltseva.task3;

import com.degaltseva.MyRunnable;

import java.util.*;


public class Task3 implements MyRunnable {

    @Override
    public void run() {
        List<Employee> employees = createList();

        showFilterEmployee(employees);
    }

    private ArrayList<Employee> createList() {
        return new ArrayList<>(List.of(
                new Employee("Иванов Иван", 20, "IT", 90000),
                new Employee("Петров Пётр", 35, "Бухгалтерия", 75000),
                new Employee("Иванова Анна", 42, "HR", 80000),
                new Employee("Кулигин Алексей", 29, "IT", 150000),
                new Employee("Петрова Ольга", 33, "Продажи", 95000)
        ));
    }

    private void showFilterEmployee(List<Employee> employees) {
        System.out.println("Сотрудники старше 30 лет:");
        employees.stream()
                .filter(e -> e.getAge() > 30)
                .forEach(System.out::println);
    }
}
