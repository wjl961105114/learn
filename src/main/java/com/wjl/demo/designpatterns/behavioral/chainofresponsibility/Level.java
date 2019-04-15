package com.wjl.demo.designpatterns.behavioral.chainofresponsibility;

/**
 * 处理权限
 *
 * @author wangJiaLun
 * @date 2019-04-15
 **/
public class Level {

    private int level;

    public Level(int level) {
        this.level = level;
    }

    boolean above (Level level){
        return this.level > level.level;
    }
}
