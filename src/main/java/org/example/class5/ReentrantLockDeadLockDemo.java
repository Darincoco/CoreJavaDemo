package org.example.class5;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDeadLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock1.lock();
            System.out.println("Thread1 acquired lock1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            lock2.lock();
            System.out.println("Thread1 acquired lock2");
            lock1.unlock();
            lock2.unlock();
        });

        Thread t2 = new Thread(() -> {
            lock2.lock();
            System.out.println("Thread2 acquired lock2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            lock1.lock();
            System.out.println("Thread2 acquired lock1");
            lock2.unlock();
            lock1.unlock();
        });

        t1.start();
        t2.start();
    }
}
