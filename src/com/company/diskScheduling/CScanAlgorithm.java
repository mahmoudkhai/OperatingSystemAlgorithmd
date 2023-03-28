package com.company.diskScheduling;

import java.util.Arrays;

public class CScanAlgorithm {

    public static void cScan(int start, int[] requests, int diskSize) {
        int headMovement = 0;
        int current = start;

        // Sort requests in ascending order
        Arrays.sort(requests);

        // Move the head from start to 0
        for (int i = 0; i < requests.length; i++) {
            if (requests[i] > start) {
                headMovement += Math.abs(requests[i] - current);
                current = requests[i];
            }
        }
        headMovement += Math.abs(diskSize - current);
        current = 0;

        // Move the head from 0 to the largest request
        for (int i = 0; i < requests.length; i++) {
            if (requests[i] < start) {
                headMovement += Math.abs(requests[i] - current);
                current = requests[i];
            }
        }
        headMovement += Math.abs(diskSize - current);

        System.out.println("Total head movement: " + headMovement);
    }

}
