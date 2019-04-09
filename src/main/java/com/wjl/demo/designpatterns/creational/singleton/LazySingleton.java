package com.wjl.demo.designpatterns.creational.singleton;

/**
 * 懒汉式
 *
 * @author wangJiaLun
 * @date 2019-04-09
 **/
public class LazySingleton {

    /**
     *  私有静态实例
     */
    private static LazySingleton instance;

    /**
     *  私有构造器
     */
    private LazySingleton() {
    }

    /**
     *  公共静态获取静态实例方法
     *  如果实例为空生成实例
     * @return 实例
     */
    public static LazySingleton getInstance(){
        // 缺点:
        // 多线程并发操作时候，线程A调用getInstance()判断对象为空 去创建对象时
        // 线程B调用getInstance()判断对象为空 也会去创建对象
        // 造成单例模式却生成了多个实例对象
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
