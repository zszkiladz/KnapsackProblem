package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.setWeightKnapsack(10);

        knapsack.addThingToKnapsack(new Thing(10, 5));
        knapsack.addThingToKnapsack(new Thing(40, 4));
        knapsack.addThingToKnapsack(new Thing(30, 6));
        knapsack.addThingToKnapsack(new Thing(50, 3));

        System.out.println(knapsack.getMaxValue());
        System.out.println(knapsack.getIndexesOfTakenThings());

    }
}
