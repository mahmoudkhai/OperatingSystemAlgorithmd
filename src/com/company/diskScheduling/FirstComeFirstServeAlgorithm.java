package com.company.diskScheduling;

public class FirstComeFirstServeAlgorithm {

    public FirstComeFirstServeAlgorithm() {

    }

    // First-Come-First-Served algorithm
    public int firstComeFirstServe(int headPosition, int[] requests) {
        int totalSeekTime = 0;
        int currentPosition = headPosition;
        for (int request : requests) {
            totalSeekTime += Math.abs(request - currentPosition);
            currentPosition = request;
        }
        return totalSeekTime;
    }
}
