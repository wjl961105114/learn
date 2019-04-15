package com.wjl.demo.designpatterns.behavioral.chainofresponsibility;

/**
 * 责任链模式测试demo
 *
 * @author wangJiaLun
 * @date 2019-04-15
 **/
public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        AbstractHandler handler1 = new ConcreteHandler1();
        AbstractHandler handler2 = new ConcreteHandler2();
        AbstractHandler handler3 = new ConcreteHandler3();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        Response response = handler1.handleRequest(new Request(new Level(2)));
    }
}
