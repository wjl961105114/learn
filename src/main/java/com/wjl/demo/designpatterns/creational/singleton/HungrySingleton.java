package com.wjl.demo.designpatterns.creational.singleton;

/**
 * 饿汉式
 *
 * @author wangJiaLun
 * @date 2019-04-09
 **/
public class HungrySingleton {

    // 缺点:
    // 访问其他静态资源也会对 instance 对象进行初始化，浪费资源

    /**
     *  私有静态实例
     * 基于classloder避免线程安全问题
     * （因为虚拟机保证只会装载一次，在装载类的时候是不会发生并发）
     */
    private static HungrySingleton instance = new HungrySingleton();


//    也可以放到静态代码块中
//    static {
//        instance = new HungrySingleton();
//    }

    /**
     *  私有构造器
     */
    private HungrySingleton(){}

    /**
     *  公共静态方法获取实例
     * @return 实例
     */
    public static HungrySingleton getInstance(){
        return instance;
    }

}
