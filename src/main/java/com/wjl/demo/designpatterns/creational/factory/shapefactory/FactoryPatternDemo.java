package com.wjl.demo.designpatterns.creational.factory.shapefactory;

/**
 * 工程模式演示类
 *
 * @author wangJiaLun
 * @date 2019-04-08
 **/
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape  circle = shapeFactory.getShape(ShapeEnum.CIRCLE.getDesc());
        circle.draw();
        Shape square = shapeFactory.getShape(ShapeEnum.SQUARE.getDesc());
        square.draw();
        Shape rectangle = shapeFactory.getShape(ShapeEnum.RECTANGLE.getDesc());
        rectangle.draw();
    }
}
