package org.example.class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Class4Notes {
/*

1. Stream API:
    new feature in Java8  java.util stream package, performs lazy computation.

    lazy computation vs eager computation:
        lazy computation: when needed, compute result
        eager computation: compute result immediately

    intermediate operation vs terminal operation
        intermediate operation: any operation that will return a stream, can chain other operations after it
                                e.g. filter, map, flat map, distinct, limit...
        terminal operation: operation that return the normal datatype, can not append other operation after it
                            e.g. collect, forEach, reduce, min, max...

    Advantage: temperate variable created by stream is immutable, ensure thread safety

    use case:
        List<Integer> list = new ArrayList<>(Arrays.asList(1,5,2,6,8,1,9));
        // perform +1 , get even result
        List<Integer> res = list.stream().map(e -> e + 1).filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(res);

        Character[] array = new Character[]{'a', 'b', 'c', 'b'};
        // count the frequency
        Map<Character, Integer> map = Arrays.stream(array).collect(Collectors.toMap(c -> c, v -> 1, (a, b) -> (a + b)));
        Map<Character, Integer> map =
                Arrays.stream(array).collect(Collectors.groupingBy(c-> c, Collectors.summingInt(e-> 1)));
        System.out.println(map);


2. Multi-threading
    Thread vs Process:
        Thread: one part of process, each thread share heap, memory space,but has independent stack, PC register
        Process: has independent memory space, stack, heap, operation resources. It contains threads

        thread state(thread life cycle): new, runnable, blocked, waiting, timed_waiting, terminated
        relationships:
                                   ┌──────────┐
                                   │   new    │
                                   └────┬─────┘
                                        │   acquiring┌───────────┐
                                      start┌────────►│  blocked  │
                                        │  │ a block └───┬───────┘
                                        │  │             │
        ┌────────────┐ interrupted ┌────▼──┴──┐          │lock acquired
        │ terminated │◄────────────┤ runnable │◄─────────┤
        └────────────┘  finished   └┬───▲───┬─┘          │
                                    │   │   │            │notification acquired
                                    │   │   │ waiting┌───┴─────┐
                              timed │   │   └───────►│ waiting │
                             waiting│   │timed out/  └─────────┘
                                   ┌▼───┴────┐ notification
                                   │  timed  │
                                   │ waiting │
                                   └─────────┘

    4 ways to create thread:
        extends Thread: create a new class directly

        implements Runnable interface: when creating a Thread class, need to pass a Runnable class into Thread Class

        implements Callable interface: when creating a Thread class, need to pass a Runnable class into Thread Class,
        in this case, it is created by a Callable class. ALSO, Callable class need to return sth in run method

        thread pool: utilize a number of thread for tasks, when tasks finished, return these thread back to pool. It
        will be in charge of creation and destroy.
        why need it? create a thread and destroy cost a lot of computation power
        Params in ThreadPoolExecutor:
            corePoolSize: number of threads always exist even when idle,
            maximumPoolSize: max number of threads can use(corePoolSize + temporary size),
            keepAliveTime: how long the temporary thread will exist,
            TimeUnit,
            workQueue: a blocking queue that stores tasks when coolPoolSize's threads are all working(FIFO),
            threadFactory,
            handler: when tasks exceed the maximumPoolSize, the extra task will be handled by handler
                    AbortPolicy(default): throw a RejectedExecutionException
                    CallerRunPolicy: use main thread that executes the threadPool to process the task
                    DiscardPolicy: discard the current task
                    DiscardOldestPolicy: discard the oldest tasks in the working queue and execute again
            Pre-defined threadPool:
                newFixedThreadPool(n): n fixed threads and maximum thread is also n, which means no temporary thread
                    potential problem: only has fixed threads, and working queue is an unlimited linkedBlockingQueue,
                    can easily cause out of memory problem if add too many tasks
                newSingleThreadPool: only 1 core thread and no temporary thread
                    potential problem: working queue is an unlimited linkedBlockingQueue, can easily cause
                    out of memory problem if add too many tasks
                newCachedThreadPool: no core thread, no limit on temporary threads, each temporary thread exist for 60s
                    potential problem: theoretically can create unlimited temporary threads(actually an object in JVM),
                    these objects will also cause out of memory questions
                newScheduleThreadPool: limited core thread and unlimited temporary thread
                    potential problem: theoretically can create unlimited temporary threads(actually an object in JVM),
                    these objects will also cause out of memory questions

        Runnable vs Callable:
        Runnable: override run method, no return, no exception
        Callable: override call method, has return, need try catch exception

 */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,5,2,6,8,1,9));
//        // perform +1 , get even result
//        List<Integer> res = list.stream().map(e -> e + 1).filter(e -> e % 2 == 0).collect(Collectors.toList());
//        System.out.println(res);
//
//        Character[] array = new Character[]{'a', 'b', 'c', 'b'};
//        // count the frequency
//        Map<Character, Integer> map = Arrays.stream(array).collect(Collectors.toMap(c -> c, v -> 1, (a, b) -> (a + b)));
//        Map<Character, Integer> map =
//                Arrays.stream(array).collect(Collectors.groupingBy(c-> c, Collectors.summingInt(e-> 1)));
//        System.out.println(map);

//        Thread t1 = new MyThread();
//        t1.start();
//
//        Thread t2 = new Thread(new RunnableThread());
//        t2.start();
//
//        FutureTask task = new FutureTask(new CallableThread());
//        Thread t3 = new Thread(task);
//        t3.start();
//        System.out.println(task.get());

//        ExecutorService threadPool = new ThreadPoolExecutor(
//                2,
//                5,
//                2L,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(4),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//
//        for (int i = 1; i < 10; i++) {
//            int taskNum = i;
//            threadPool.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " is working on " + taskNum + " task");
//            });
//        }
//
//        threadPool.shutdown();

        ExecutorService tp1 = Executors.newFixedThreadPool(2);
        ExecutorService tp2 = Executors.newSingleThreadExecutor();
        ExecutorService tp3 = Executors.newCachedThreadPool();
        ExecutorService tp4 = Executors.newScheduledThreadPool(2);
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread is created by extending Thread Class");
    }
}

class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread is created by implementing Runnable interface");
    }
}

class CallableThread implements Callable{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Thread is created by implementing Callable interface");
        return 111;
    }
}