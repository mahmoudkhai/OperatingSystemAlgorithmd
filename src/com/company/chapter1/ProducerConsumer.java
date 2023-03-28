package com.company.chapter1;

import java.util.LinkedList;

public class ProducerConsumer {

    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    wait(); //Causes the current thread to wait until it is awakened, typically by being notified or interrupted.
                }

                buffer.add(value++);
                System.out.println("Produced: " + value);

                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.size() == 0) {
                    wait();
                }

                int value = buffer.removeFirst();
                System.out.println("Consumed: " + value);

                notify();
                Thread.sleep(1000);
            }
        }
    }
}