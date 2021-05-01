package com.practice;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockProblem {
    String name1 = "Raju";
    String name2 = "Shyam";

    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    /*public void accessResources() throws InterruptedException {
     *//*ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println(name1.toLowerCase(Locale.ROOT));
        Thread.sleep(1000);
        lock.lock();
        System.out.println(name2.toLowerCase(Locale.ROOT));
        lock.unlock();
        lock.unlock();*//*

    }*/

    /*public void access2Resources() throws InterruptedException {
     *//*ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println(name2.toLowerCase(Locale.ROOT));
        Thread.sleep(1000);
        lock.lock();
        System.out.println(name1.toLowerCase(Locale.ROOT));
        lock.unlock();
        lock.unlock();*//*
        lock2.lock();
        System.out.println(name1.toLowerCase(Locale.ROOT));
        Thread.sleep(1000);
        lock1.lock();
        System.out.println(name2.toLowerCase(Locale.ROOT));
        lock1.unlock();
        lock2.unlock();
    }*/

    /*public void resourceB() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        //resourceA();
        System.out.println(name2.toLowerCase(Locale.ROOT));
        lock.unlock();
    }*/

    public static void main(String[] args) {
        new DeadlockProblem().tryDeadlock();
    }

    public void tryDeadlock() {

        DeadlockProblem deadlockProblem = new DeadlockProblem();
        Thread t1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println(name1.toLowerCase(Locale.ROOT));
                Thread.sleep(1000);
                lock2.lock();
                System.out.println(name2.toLowerCase(Locale.ROOT));
                lock2.unlock();
                lock1.unlock();
            } catch (InterruptedException e) {

            }

        });
        Thread t2 = new Thread(() -> {
            try {
                lock2.lock();
                System.out.println(name1.toLowerCase(Locale.ROOT));
                Thread.sleep(1000);
                lock1.lock();
                System.out.println(name2.toLowerCase(Locale.ROOT));
                lock1.unlock();
                lock2.unlock();
            } catch (InterruptedException e) {

            }

        });
        t1.start();
        t2.start();
    }
}
