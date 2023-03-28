package com.company.chapter1;

public class TestAndSetLock {

    private volatile boolean isLocked = false;

    public synchronized void lock() {
        while (isLocked) {
            // wait until lock is released
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
}
}
