package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PhaserDemo {

    private static AtomicInteger counter = new AtomicInteger(1);
    private CountDownLatch countDownLatch;
    private CyclicBarrier barrier;
    private Phaser phaser;

    public PhaserDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public PhaserDemo(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public PhaserDemo(Phaser phaser) {
        this.phaser = phaser;
    }

    public void basicLockingUsingThreadPool(int millis) {

        try {
            Thread.sleep(millis);
            //locker.lock();
            System.out.println(Thread.currentThread().getName() + " Executing for " + counter.getAndIncrement() + "th time");
            if (null != countDownLatch) {
                countDownLatch.countDown();
            }
            if (null != barrier) {
                barrier.await();
                System.out.println("barrier broken for " + Thread.currentThread().getName());
            }
            if (null != phaser) {
                phaser.arriveAndAwaitAdvance();
                System.out.println("phaser broken for " + Thread.currentThread().getName());
            }
            //counter.getAndIncrement();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            //locker.unlock();
        }

        /*System.out.println("Executing for " + counter.get() + "th time");
        counter.getAndAdd(1);*/
    }

    public void testBasicLockingUsingThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<String>> taskList = new ArrayList<>();
        //PhaserDemo phaserDemo = new PhaserDemo();
        /*IntStream.range(0, 10).forEach(x ->
                taskList.add(() -> {
                    new PhaserDemo().basicLockingUsingThreadPool();
                    return "done";
                })
        );*/


        IntStream.range(0, 10).forEach(x -> executorService.submit(() -> this.basicLockingUsingThreadPool(x * 1000)));
        try {
            if (null != this.countDownLatch) {
                this.countDownLatch.await();
                System.out.println("latched out");
            }
            /*if (null != phaser) {
                phaser.arrive();
                System.out.println("phaser broken for " + Thread.currentThread().getName());
            }*/
        } catch (InterruptedException e) {

        }
        executorService.shutdown();
    }

    public static void main(String args[]) throws InterruptedException {
        //new PhaserDemo(new CountDownLatch(10)).testBasicLockingUsingThreadPool();
        //new PhaserDemo(new CyclicBarrier(5)).testBasicLockingUsingThreadPool();
        new PhaserDemo(new Phaser(5)).testBasicLockingUsingThreadPool();
    }


}
