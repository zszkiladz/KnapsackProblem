package com.company;

import java.util.List;

public class Result {
    private final int value;
    private final List<Integer> takenThingsIndexes;

    public Result(int value, List<Integer> takenThingsIndexes) {
        this.value = value;
        this.takenThingsIndexes = takenThingsIndexes;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getTakenThingsIndexes() {
        return takenThingsIndexes;
    }

    @Override
    public String toString() {
        return "Result{" +
                "value=" + value +
                ", TakenThingsIndexes=" + takenThingsIndexes +
                '}';
    }
}
