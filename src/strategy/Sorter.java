package strategy;

import java.util.Arrays;

public class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] sort(int[] data) {
        return strategy.sort(data);
    }

    public String sortAsString(int[] data) {
        return Arrays.toString(sort(data));
    }
}
