package com.practice;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadTimeoutProblem {

    public static void main(String[] args) throws InterruptedException {
        /*ExecutorService executor = Executors.newFixedThreadPool(2);
        Task runnableTask = new Task();
        executor.submit(runnableTask);
        Thread.sleep(100);
        runnableTask.interrupter.getAndSet(true);*/

        RunnableTask runnableTask = new ThreadTimeoutProblem().new RunnableTask();
        Thread t1 = new Thread(runnableTask);
        t1.start();

        Thread.sleep(1000);
        runnableTask.stop();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new ThreadTimeoutProblem().new CallableTask());
        try {
            future.get(1000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            future.cancel(true);
        } finally {
            executorService.shutdownNow();
        }


    }

    public class RunnableTask implements Runnable {
        public AtomicBoolean interrupter = new AtomicBoolean(false);

        @Override
        public void run() {
            while (interrupter.get()) {
            }
            System.out.println("interrupted");
        }

        public void stop() {
            interrupter.set(true);
        }
    }

    public class CallableTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            while (!Thread.interrupted()) {
                System.out.println("running");
            }
            System.out.println("callable-interrupted");
            return null;
        }
    }
}
