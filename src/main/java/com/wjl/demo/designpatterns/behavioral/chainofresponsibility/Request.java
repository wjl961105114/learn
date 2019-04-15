package com.wjl.demo.designpatterns.behavioral.chainofresponsibility;

/**
 * 请求
 *
 * @author wangJiaLun
 * @date 2019-04-15
 **/
public class Request {

    private Level level;

    public Request(Level level) {
        this.level = level;
    }

    Level getLevel() {
        return level;
    }
}
