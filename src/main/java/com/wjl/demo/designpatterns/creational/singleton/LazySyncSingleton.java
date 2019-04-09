package com.wjl.demo.designpatterns.creational.singleton;

/**
 * 懒汉式单例 加同步锁
 *
 * @author wangJiaLun
 * @date 2019-04-09
 **/
public class LazySyncSingleton {

    /**
     *  私有静态对象
     */
    private static LazySyncSingleton instance;

    /**
     *  私有构造器
     */
    private LazySyncSingleton(){}

    /**
     * 公共静态获取静态实例方法
     * 如果实例为空生成实例
     * 添加线程同步锁
     * @return
     */
    public synchronized LazySyncSingleton getInstance(){
        // 缺点:
        // 当线程A访问此方法时
        // 其他线程都被挂起等待
        // 避免了多实例 但是造成无谓的等待
        if (null == instance) {
            instance = new LazySyncSingleton();
        }
        return instance;
    }


}
