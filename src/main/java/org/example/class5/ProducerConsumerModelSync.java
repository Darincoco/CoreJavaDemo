package org.example.class5;

import java.util.*;

public class ProducerConsumerModelSync {

    private final int capacity = 3;
    private Queue<Integer> queue = new LinkedList<>();
    private static Random myRandomInt = new Random();

    public synchronized void produce() throws InterruptedException {
        int value = myRandomInt.nextInt();
        for (int i = 0; i < 5; i++) {
            while (queue.size() == capacity) {
                System.out.println(Thread.currentThread().getName() + " wait, queue is full");
                wait();
            }
            queue.offer(value);
            System.out.println(Thread.currentThread().getName() + " put " + value);
            notifyAll();
            Thread.sleep(1000);
        }
    }

    public synchronized void consume() throws InterruptedException {
        int value = myRandomInt.nextInt();
        for (int i = 0; i < 5; i++) {
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " wait, queue is empty");
                wait();
            }
            queue.poll();
            System.out.println(Thread.currentThread().getName() + " take " + value);
            notifyAll();
            Thread.sleep(1000);
        }
    }
    public static void main(String[] args) throws InterruptedException {

        ProducerConsumerModelSync pc = new ProducerConsumerModelSync();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
