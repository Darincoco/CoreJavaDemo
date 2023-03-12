package org.example.class5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            // initial Num = 1
            int num = 1;

            // async: num += 10
            num += 10;
            return num;
        }).thenApply((num) -> {
            // sync: num *=4
            return num * 4;
        }).thenAccept((num) -> {
            // async: consume result and print
            System.out.println("Result is : " + num);
        }).exceptionally((exc) -> {
            System.out.println(exc.getMessage());
            return null;
        });

        System.out.println(future.get());
    }
}
