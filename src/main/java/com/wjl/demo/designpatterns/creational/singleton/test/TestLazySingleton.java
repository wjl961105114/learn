package com.wjl.demo.designpatterns.creational.singleton.test;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.wjl.demo.designpatterns.creational.singleton.LazySingleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 懒汉式单例测试
 *
 * @author wangJiaLun
 * @date 2019-04-09
 **/
public class TestLazySingleton {

    /**
     *  方法标记
     */
    private boolean flag;


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<>());
        final TestLazySingleton lock = new TestLazySingleton();
        lock.setFlag(true);

        // 线程数目
        int threadSize = 5;

        ThreadFactory lazySingleton = new ThreadFactoryBuilder()
                .setNameFormat("thread-lazySingleton-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(
                0,threadSize,60L,
                TimeUnit.SECONDS,new SynchronousQueue<>(),lazySingleton);

        for (int i = 0; i <threadSize ; i++) {
            executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            while (true){
                                if (!lock.isFlag()) {
                                    LazySingleton lazySingleton = LazySingleton.getInstance();;
                                    instanceSet.add(lazySingleton.toString());
                                    break;
                                }
                            }
                        }
                    }
            );
        }
        try {
            // 阻塞main主线程
            Thread.sleep(5000L);
            // 将锁打开
            lock.setFlag(false);
           //  保证所有线程都调用getInstance(）
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        instanceSet.forEach(System.out::println);
        executorService.shutdown();
    }
}

