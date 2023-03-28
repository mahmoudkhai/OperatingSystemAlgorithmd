package com.company.chapter1;

public class SemaphoreLock {

    private int permits;

    public SemaphoreLock(int permits) {
        this.permits = permits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permits == 0) {
            wait();
        }
        permits--;
    }

    public synchronized void release() {
        permits++;
        notify();
}
}