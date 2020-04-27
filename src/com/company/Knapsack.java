package com.company;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private final List<Thing> things = new ArrayList<>();
    private int weightKnapsack;

    public void add(Thing thing) {
        things.add(thing);
    }

    public void addAll(List<Thing> things) {
        this.things.addAll(things);
    }

    public void remove(Thing thing) {
        things.remove(thing);
    }

    public void remove(int index) {
        things.remove(index);
    }

    public int getMaxValue() {
        if (things.isEmpty()) {
            return -1;
        }
        int[][] tab = getTable();
        return tab[things.size()][weightKnapsack];
    }

    private int[][] getTable() {
        int[][] tab = new int[things.size() + 1][weightKnapsack + 1];
        for (int i = 0; i < things.size(); i++) {
            int weight = things.get(i).weight;
            int price = things.get(i).price;
            if (weight >= 0) System.arraycopy(tab[i], 0, tab[i + 1], 0, weight);
            for (int j = weight; j <= weightKnapsack; j++) {
                tab[i + 1][j] = Math.max(price + tab[i][j - weight], tab[i][j]);
            }
        }
        return tab;
    }

    public List<Integer> getIndexesOfTakenThings() {
        List<Integer> takenThings = new ArrayList<>();
        int[][] tab = getTable();

        for (int i = things.size(); i > 0 && weightKnapsack > 0; i--) {
            if (tab[i][weightKnapsack] > tab[i - 1][weightKnapsack]) {
                takenThings.add(i);
                weightKnapsack = weightKnapsack - things.get(i - 1).weight;
            }
        }
        takenThings.sort(Integer::compareTo);
        return takenThings;
    }

    public void printTable() {
        int[][] table = getTable();
        System.out.print("   ");
        for (int i = 0; i < table[0].length; i++) {
            System.out.print(String.format("%2d", i) + " ");
        }
        System.out.println();
        for (int i = 0; i <= table[0].length; i++) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(String.format("%2d", i) + "|");
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(String.format("%2d", table[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public int getWeightKnapsack() {
        return weightKnapsack;
    }

    public void setWeightKnapsack(int weightKnapsack) {
        this.weightKnapsack = weightKnapsack;
    }
}
