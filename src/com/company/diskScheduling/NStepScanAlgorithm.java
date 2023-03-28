package com.company.diskScheduling;

public class NStepScanAlgorithm {

    public int[] nStepScan(int[] input, int n, int threshold) {
        int[] output = new int[input.length]; // Initialize the output array

        for (int i = 0; i < input.length; i++) {
            int sum = input[i]; // Initialize the sum to the current element

            // Calculate the sum of the next n-1 elements
            for (int j = 1; j < n; j++) {
                if (i + j < input.length) { // Check if the index is within the input array
                    sum += input[i + j];
                }
            }

            // Check if the sum exceeds the threshold
            if (sum > threshold) {
                output[i] = 1; // Set the output to 1 if the sum exceeds the threshold
            } else {
                output[i] = 0; // Set the output to 0 otherwise
            }
        }

        return output; // Return the output array
    }
}