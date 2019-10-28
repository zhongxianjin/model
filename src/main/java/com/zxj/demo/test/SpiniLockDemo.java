package com.zxj.demo.test;

import org.junit.*;

import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by upc on 2019/10/9.
 */
public class SpiniLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void setLock() {
        Thread thread = Thread.currentThread();
        System.out.println("begain" + Thread.currentThread().getName());
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println("end" + thread.getName());
        atomicReference.compareAndSet(thread, null);
        System.out.println("end" + Thread.currentThread().getName());
    }

//    @org.junit.Test
//    public void test() {
//        SpiniLockDemo demo = new SpiniLockDemo();
//        new Thread(() -> {
//            demo.setLock();
//            System.out.println("ks" + Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            demo.unLock();
//        }, "A").start();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(() -> {
//            demo.setLock();
//            System.out.println("ks" + Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            demo.unLock();
//        }, "B").start();
//    }

    public static void main(String[] args) {
        SpiniLockDemo demo = new SpiniLockDemo();
        new Thread(() -> {
            demo.setLock();
            System.out.println("ks" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.unLock();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            demo.setLock();
            System.out.println("ks" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.unLock();
        }, "B").start();

    }
}
