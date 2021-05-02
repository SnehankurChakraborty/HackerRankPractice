package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class CounterDemo {

    private static int counter = 0;
    private static final Object lock = new Object();
    private final ReentrantLock locker;

    public CounterDemo(ReentrantLock locker) {
        this.locker = locker;
    }


    private void increaseCounter() {
        try {
            locker.tryLock(1, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + " : " + counter++);
        } catch (InterruptedException e) {

        } finally {
            locker.unlock();
        }


    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CounterDemo counterDemo = new CounterDemo(new ReentrantLock());
        IntStream.rangeClosed(0, 10).parallel().forEach(x -> executorService.submit(counterDemo::increaseCounter));
        executorService.shutdown();
    }
}
