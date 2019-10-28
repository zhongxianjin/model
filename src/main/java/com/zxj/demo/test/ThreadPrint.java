package com.zxj.demo.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by upc on 2019/9/24.
 */
public class ThreadPrint {
    public static int count = 0;
    public static Object Lock = new Object();

    static class RunnableImple implements Runnable {

        @Override
        public void run() {
            countNumber();
        }
    }

    public static void countNumber() {
        synchronized (Lock) {
            System.out.println("开始:" + Thread.currentThread().getName());
            count++;
//            try {
                System.out.println(count);
//                if (count < 10) {
//                    Lock.wait();
//                } else {
//                    Lock.notifyAll();
//                }
                System.out.println("完成:" + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }
    public static void main(String[] args){
        for(int i=0;i<100;i++){
            Thread thread=new Thread(new RunnableImple());
            thread.start();
        }
//        Executor executor= Executors.newFixedThreadPool(10);
//        Executor executor= Executors.newCachedThreadPool();
//        Executor executor= Executors.newSingleThreadExecutor();
//        ExecutorService executor= Executors.newCachedThreadPool();
        ExecutorService executor= Executors.newFixedThreadPool(10);
//        for(int i=0;i<100;i++){
//            executor.execute(new RunnableImple());
//        }
//        executor.shutdown();
//        for (int i = 0; i < 5; i++){
//            executor.execute(new TestRunnable());
//            System.out.println("************* a" + i + " *************");
//        }
//        executor.shutdown();
    }
}
class TestRunnable implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}