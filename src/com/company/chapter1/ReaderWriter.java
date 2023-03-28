package com.company.chapter1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriter {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int data;

    public int read() {
        lock.readLock().lock();
        try {
            return data;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int value) {
        lock.writeLock().lock();
        try {
            data = value;
        } finally {
            lock.writeLock().unlock();
        }
    }
}