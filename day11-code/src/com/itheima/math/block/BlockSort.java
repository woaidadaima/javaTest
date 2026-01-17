package com.itheima.math.block;

public class BlockSort {
    int min;
    int max;
    int fromIndex;
    int endIndex;

    public BlockSort() {
    }

    public BlockSort(int min, int max, int fromIndex, int endIndex) {
        this.min = min;
        this.max = max;
        this.fromIndex = fromIndex;
        this.endIndex = endIndex;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
