package com.wjl.demo.designpatterns.creational.singleton;

/**
 * 双重校验锁
 *  JDK5 或更高版本使用
 *  因为从 JDK5 开始使用新的 JSR-133 内存模型规范，这个规范增强了 volatile 的语义
 * @author wangJiaLun
 * @date 2019-04-15
 **/
public class DoubleCheckLockSingleton {

    // Volatile可以保证可见性和有序性，无法保证原子性
    // 同时保证JVM对指令不会进行重排序

    /**
     *  需要添加 volatile 关键字原因是禁止重排序
     *      instance = new DoubleCheckLockSingleton();
     *  分为三个指令（伪代码）
     *      memory = allocate();        // 1：分配对象的内存空间
     *      ctorInstance(memory);    // 2：初始化对象
     *      instance = memory;        // 3：设置 instance 指向刚分配的内存地址
     * 《The Java Language Specification, Java SE 7 Edition》
     *  规范中定义所有线程执行Java程序时必须遵守intra-thread semantics
     *  保证重排序不会改变单线程内的程序执行结果，所以上述2，3步骤
     *  允许被重排序提供程序执行效率
     *  多线程并发时，如果重排序:
     *      instance对象已经被分配内存地址,未被初始化
     *      其他线程会获取到一个未被初始化的instance
     */
    private volatile static DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton(){}

    public static DoubleCheckLockSingleton getInstance(){
        // 判断对象是否已经生成
        // 生成则不进入下面的同步代码
        if (null == instance) {
            synchronized (DoubleCheckLockSingleton.class){
                // 当线程A通过第一层if判断准备进入同步代码时
                // 线程B也通过判断进入同步代码
                // 不加判断线程A&B都会创建新的对象
                if (null == instance) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}
