package org.example.class5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Class5Notes {
/*
1. CompletableFuture: class implemented from interface Future and CompletionState.
    Future: easily interact with threadPool
    CompletionState: provide some API which make method more flexible

    Sync and async: Sync is single-thread, so only one operation or program will run at a time. Async is non-blocking,
                    which means it will send multiple requests to a server

    CompletableFuture without return use case:
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            System.out.println("main thread starts");
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try{
                    System.out.println("a chill thread start working");
                    Thread.sleep(5000);
                    System.out.println("the chill thread done");
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            });
            future.get();
            System.out.println("main thread ends");
        }
    CompletableFuture with return use case:
        System.out.println("main thread starts");
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try{
                    System.out.println("a chill thread start working");
                    Thread.sleep(5000);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
                return "the chill thread done";
            });
            System.out.println("Task result: " + future.get());
            System.out.println("main thread ends");

    ** CompletableFuture can chain many method after one method, Future can not. **

    CompletableFuture chain operation case (after one operation, use then... to continue operation):
        System.out.println("main thread starts");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("a chill thread start working");
                num+=50;
                return num;
            }).thenApply(val -> {
                return val * 2;
        });
        System.out.println("Task result: " + future.get());
        System.out.println("main thread ends");

    CompletableFuture handle exception (using exceptionally to catch exception):
        System.out.println("main thread starts");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 1 / 0;
            System.out.println("add 10 to num");
            num += 10;
            return num;
        }).exceptionally(exc -> {
            System.out.println(exc.getMessage());
            return 404;
        });
        System.out.println("Task result: " + future.get());
        System.out.println("main thread ends");

    CompletableFuture handle method (use handle()):
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 1 / 0;
            System.out.println("add 10 to num");
            num += 10;
            return num;
        }).handle((val, exc) -> {
            System.out.println("get into the handle method");
            if (exc == null) {
                System.out.println("task is done");
                return num;
            } else {
                System.out.println("exception thrown " + exc.getMessage());
                return 400;
            }
        });

    ** CompletableFuture can handle exception while Future can only throw it **
    ** CompletableFuture can combine the results of different tasks using thenCompose, thenCombine **

    Research on thenCompose(), thenCombine():
        thenCompose(): is used when the result of one future is needed to compute another future
        thenCombine(): is used when the results of two or more futures need to be combined

    Method differences: allOf, anyOf
        allOf: is used to wait for the completion of multiple futures
        anyOf: is used to wait for the completion of the first future that completes


2. Lock
    Parallel vs concurrent
        parallel: different thread do different task
        concurrent: different thread do same task

    Lock:
        synchronized: used on code block, method, static method, class
        lock interface: implemented by ReentrantLock class, which has lock(), unlock, tryLock(), newCondition()...
        ReadWriteLock interface: extended from lock interface, implemented by ReentrantReadWriteLock, has
            Lock readLock() / Lock writeLock()
        Pros and cons:
            synchronized can lock it automatically, no need to unlock it manually
            lock need to lock and unlock it manually, lock provide condition for different scenarios, make lock more
            flexible
        Fair lock vs unfair lock:
            fair lock: first come, first serve -> ReentrantLock
            unfair lock: can't guarantee which thread will access the task order -> Synchronized

    Synchronized use case:
        class TestClass {
            public void method(){
                synchronized (TestClass.class){
                    //class level lock
                    //TODO
                }
            }

            public synchronized void method1(){
                //object level lock
                //TODO
            }

            public synchronized static void method2(){
                // class level lock
                //TODO
            }

            public void method3(){
                synchronized (this){
                    // code block level lock
                    //TODO
                };
            }
        }

    ReentrantLock use case:


3. dead lock
    Definition: two or more threads are waiting for each other
    Solve: first find dead lock, in command use jps find stack no. and jstack + no.
    How to prevent:
        1. avoid nested lock
        2. avoid unnecessary lock(Stack, Vector, Hashtable)
        3. use Thread.join()

 */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }

}

class TestClass {
    public void method(){
        synchronized (TestClass.class){
            //class level lock
            //TODO
        }
    }

    public synchronized void method1(){
        //object level lock
        //TODO
    }

    public synchronized static void method2(){
        // class level lock
        //TODO
    }

    public void method3(){
        synchronized (this){
            // code block level lock
            //TODO
        };
    }
}
