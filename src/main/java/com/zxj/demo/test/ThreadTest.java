package com.zxj.demo.test;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by upc on 2019/8/30.
 */
public class ThreadTest{
    public static int count = 0;
    public static Object Lock = new Object();
    static class RunnableImple implements Runnable{

        @Override
        public void run() {
            countNumber();
        }
    }
    public static void main(String[] args) {
//        ThreadTest threadTest = new ThreadTest();
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable3 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable4 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable5 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable6 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable7 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable8 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable9 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
//        Runnable runnable10 = new Runnable() {
//            @Override
//            public void run() {
//                if(count<10){
//                    synchronized(Lock){
//                        count++;
//                        System.out.println(count);
//                    }
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    count++;
//                    System.out.println(count);
//                    this.notifyAll();
//                    System.out.println("完成");
//                }
//            }
//        };
////        for(int i=0;i<10;i++){
//        Thread thread1 = new Thread(runnable1);
//        Thread thread2 = new Thread(runnable2);
//        Thread thread3 = new Thread(runnable3);
//        Thread thread4 = new Thread(runnable4);
//        Thread thread5 = new Thread(runnable5);
//        Thread thread6 = new Thread(runnable6);
//        Thread thread7 = new Thread(runnable7);
//        Thread thread8 = new Thread(runnable8);
//        Thread thread9 = new Thread(runnable9);
//        Thread thread10 = new Thread(runnable10);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//        thread9.start();
//        thread10.start();
//        for(int i=0;i<100;i++){
//            Thread thread11 = new Thread(runnable);
//            thread11.start();
////            try {
////                thread11.wait();
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            if(i==99){
////                thread11.notifyAll();
////            }
//        }
//        }
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new RunnableImple());
            thread.start();
        }
//        ThreadTest myThread = new ThreadTest();
//        Thread thread = new Thread(myThread);
//        thread.start();
//
//        ThreadTest threadTest1 = new ThreadTest();
//        threadTest1.start();
//
//        Callable<Object> oneCallable = new ThreadTest();
////由Callable<Integer>创建一个FutureTask<Integer>对象：
//        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
////注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
//        //由FutureTask<Integer>创建一个Thread对象：
//        Thread oneThread = new Thread(oneTask);
//        oneThread.start();
    }

//    public void run() {
//        synchronized ((Object) count) {
//            if (count < 2) {
//
//                count++;
//                System.out.println(count);
//
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                count++;
//                System.out.println(count);
//                this.notifyAll();
//                System.out.println("完成");
//            }
//        }
//        System.out.println("MyThread.run()");
//    }

    public static   void countNumber() {
        synchronized(Lock){
            count++;
            try {
                System.out.println(count);
                if(count<10) {
                    Lock.wait();
                }else {
                    Lock.notifyAll();
                }
                System.out.println("完成"+count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

//    @Override
//    public Object call() throws Exception {
//        System.out.println("call");
//        return null;
//    }
}
