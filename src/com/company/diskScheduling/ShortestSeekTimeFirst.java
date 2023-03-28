package com.company.diskScheduling;

import java.util.Arrays;

public class ShortestSeekTimeFirst {
    public ShortestSeekTimeFirst() {
    }

    // Shortest-Seek-Time-First algorithm
    public int shortestSeekTime(int headPosition, int[] requests) {
        int totalSeekTime = 0;
        int currentPosition = headPosition;
        int[] remainingRequests = Arrays.copyOf(requests, requests.length);
        for (int i = 0; i < requests.length; i++) {
            int shortestDistance = Integer.MAX_VALUE;
            int shortestIndex = -1;
            for (int j = 0; j < remainingRequests.length; j++) {
                int distance = Math.abs(currentPosition - remainingRequests[j]);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    shortestIndex = j;
                }
            }
            totalSeekTime += shortestDistance;
            currentPosition = remainingRequests[shortestIndex];
            remainingRequests[shortestIndex] = -1;
        }
        return totalSeekTime;
    }
}
