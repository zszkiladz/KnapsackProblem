package com.company;

public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(10);
        knapsack.add(new Thing(10, 5));
        knapsack.add(new Thing(40, 4));
        knapsack.add(new Thing(30, 6));
        knapsack.add(new Thing(50, 3));

        Result result = knapsack.getResult();
        System.out.println(result);
    }
}
