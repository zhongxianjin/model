package com.zxj.demo.test;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by upc on 2019/10/7.
 */
public class TestExtend {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static int number = 0;

    @org.junit.Test
    public void test() {
//        new Children();
//        List list = new CopyOnWriteArrayList<String>();//线程安全
//        List<String> list1=Collections.synchronizedList(new ArrayList<String>());
////        ReentrantLock
////        new Parent();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }

    public static void testSynchronized() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        number++;
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
//        new Thread(()->{
////            System.out.println(Thread.currentThread().getName());
//            testSynchronized();
//        },"t1").start();
//        new Thread(()->{
////            System.out.println(Thread.currentThread().getName());
//            testSynchronized();
//        },"t2").start();
//        new Thread(()->{
////            System.out.println(Thread.currentThread().getName());
//            testSynchronized();
//        },"t3").start();
//        new Thread(()->{
////            System.out.println(Thread.currentThread().getName());
//            testSynchronized();
//        },"t4").start();
//
        final CountDownLatch latch = new CountDownLatch(10);
        ArrayList<Integer> arrayList = new ArrayList<>(5);
//        int i = 0;
//        for (i = 0; i < 10; i++) {
//            int finalI = i;
//            new Thread(() -> {
////            System.out.println(Thread.currentThread().getName());
////                testSynchronized();
//                for (int j = 0; j < 1000; j++) {
//                    arrayList.add(j);//OutOfBoundIndex
//                }
//                latch.countDown();
//            }, "t" + i).start();
//        }
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i=0;i<100;i++)arrayList.add(i);
        /**
         * ConcurrentModificationException
         */
        HashMap<String,String> map=new HashMap<>();
        Iterator<Map.Entry<String, String>> iterator=map.entrySet().iterator();
        for (Integer i:arrayList){
            arrayList.remove(i);
            arrayList.add(i);//ConcurrentModificationException
        }
        System.out.println("number" + arrayList.toString());

    }
}
