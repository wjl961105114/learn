package com.wjl.demo.designpatterns.creational.factory.shapefactory;

/**
 * 长方形
 *
 * @author wangJiaLun
 * @date 2019-04-08
 **/
public class Rectangle implements Shape{

    /**
     * 绘画
     */
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
