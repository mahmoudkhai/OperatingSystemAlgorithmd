package com.company.diskScheduling;

import java.util.Arrays;

public class ScanLook {

    public int scanLook(int headPosition, int[] requests) {
        int totalSeekTime = 0;
        int currentPosition = headPosition;
        int[] remainingRequests = Arrays.copyOf(requests, requests.length);
        Arrays.sort(remainingRequests);
        int index = Arrays.binarySearch(remainingRequests, currentPosition);
        if (index < 0) {
            index = -index - 1;
        }
        int direction = 1;
        while (index < remainingRequests.length || index >= 0) {
            if (direction == 1) {
                if (index < remainingRequests.length) {
                    totalSeekTime += Math.abs(currentPosition - remainingRequests[index]);
                    currentPosition = remainingRequests[index];
                    index++;
                } else {
                    direction = -1;
                    index--;
                }
            } else {
                if (index >= 0) {
                    totalSeekTime += Math.abs(currentPosition - remainingRequests[index]);
                    currentPosition = remainingRequests[index];
                    index--;
                } else {
                    break;
                }
            }
        }
        return totalSeekTime;

    }
}
