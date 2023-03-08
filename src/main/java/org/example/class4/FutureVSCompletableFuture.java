package org.example.class4;

import java.util.concurrent.*;

public class FutureVSCompletableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Example with Future
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futureResult = executor.submit(() ->{
            Thread.sleep(2000);
            return 42;
        });

        System.out.println("Start Computation");
        while (!futureResult.isDone()) {
            Thread.sleep(1000);
        }
        System.out.println("Result: " + futureResult.get());
        executor.shutdown();

        // Example with CompletableFuture
        CompletableFuture<Integer> completableFutureResult = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            return 42;
        });
        System.out.println("Started computation");
        completableFutureResult.thenAccept(result -> System.out.println("Result: " + result));
        completableFutureResult.join();
    }
}
