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

    public Result getResult() {
        int[][] table = getTable();
        int value = getMaxValue(table);
        List<Integer> takenThings = getIndexesOfTakenThings(table);

        return new Result(value, takenThings);
    }

    /**
     * Executes the algorithm
     *
     * @return table with result of the algorithm
     */
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

    /**
     * Calculates the highest value of taken items.
     *
     * @param table with result of algorithm
     * @return total value of taken items; -1 when there is no solution
     */
    private int getMaxValue(int[][] table) {
        if (things.isEmpty()) {
            return -1;
        }
        return table[things.size()][weightKnapsack];
    }

    /**
     * Takes indexes of taken things
     *
     * @param table with result of algorithm
     * @return list of indexes taken things
     */
    private List<Integer> getIndexesOfTakenThings(int[][] table) {
        List<Integer> takenThings = new ArrayList<>();
        for (int i = things.size(); i > 0 && weightKnapsack > 0; i--) {
            if (table[i][weightKnapsack] > table[i - 1][weightKnapsack]) {
                takenThings.add(i);
                weightKnapsack = weightKnapsack - things.get(i - 1).weight;
            }
        }
        takenThings.sort(Integer::compareTo);
        return takenThings;
    }

    public int getWeightKnapsack() {
        return weightKnapsack;
    }

    public void setWeightKnapsack(int weightKnapsack) {
        this.weightKnapsack = weightKnapsack;
    }
}
