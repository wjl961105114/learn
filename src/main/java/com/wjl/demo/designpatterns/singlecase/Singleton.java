package com.wjl.demo.designpatterns.singlecase;

/**
 *  懒汉式 非线程安全
 *
 * @author 王加伦
 * @date 2019/1/21
 */
public class Singleton {

    private static Singleton instance;

    public Singleton() {
    }

    public static Singleton getInstance(){
        if (null != instance) {
            instance = new Singleton();
        }
        return instance;
    }
}
///**
// *  懒汉式 线程安全
// *
// * @author 王加伦
// * @date 2019/1/21
// */
//public class Singleton {
//
//    private static Singleton instance;
//
//    private Singleton (){}
//    /**
//     *   加了同步锁，多线程使用，效率很低
//    */
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}
///**
// *  饿汉式
// *  基于classloder避免线程安全问题（因为虚拟机保证只会装载一次，在装载类的时候是不会发生并发）
// *  实例在类装载时候被实例化，浪费空间
// * @author 王加伦
// * @date 2019/1/21
// */
//public class Singleton {
//
//    private static Singleton instance = new Singleton();
//
//    private Singleton (){}
//
//    public static Singleton getInstance() {
//        return instance;
//    }
//}

///**
// *  饿汉式 变种 静态代码块实例化实例
// *  基于classloder避免线程安全问题（因为虚拟机保证只会装载一次，在装载类的时候是不会发生并发）
// *  实例在类装载时候被实例化，浪费空间
// * @author 王加伦
// * @date 2019/1/21
// */
//public class Singleton {
//    private static Singleton instance = null;
//
//    static {
//        instance = new Singleton();
//    }
//
//    private Singleton (){}
//
//    public static Singleton getInstance() {
//        return instance;
//    }
//}

///**
// *  静态内部类
// *  基于classloder避免线程安全问题（因为虚拟机保证只会装载一次，在装载类的时候是不会发生并发）
// *  优化上述方法，Singleton类被装载，实例也不一定被初始化，做到延迟加载
// * @author 王加伦
// * @date 2019/1/21
// */
//public class Singleton {
//
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    private Singleton (){}
//
//    public static final Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//}

///**
// *  枚举法（避免线程同步问题，放置反序列号重新创建新对象）
// *  基于classloder避免线程安全问题（因为虚拟机保证只会装载一次，在装载类的时候是不会发生并发）
// *  优化上述方法，Singleton类被装载，实例也不一定被初始化，做到延迟加载
// * @author 王加伦
// * @date 2019/1/21
// */
//public enum Singleton {
//
//    INSTANCE;
//    public void whateverMethod() {
//    }
//}

///**
// *  双重校验锁
// * @author 王加伦
// * @date 2019/1/21
// */
//public class Singleton {
//
//    private volatile static Singleton singleton;
//
//    private Singleton (){}
//    public static Singleton getSingleton() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}