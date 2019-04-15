package com.wjl.demo.designpatterns.behavioral.chainofresponsibility;

/**
 * 抽象处理类
 *
 * 主要包含一个指向下一处理类的成员变量nextHandler
 * 和一个处理请求的方法handRequest，
 * handRequest方法的主要思想是，如果满足处理的条件，则有本处理类来进行处理，否则由nextHandler来处理。
 * @author wangJiaLun
 * @date 2019-04-15
 **/
public abstract class AbstractHandler {

    /**
     *  下一个处理器
     */
    private AbstractHandler nextHandler;

    /**
     *  配置下一个处理器
     * @param nextHandler 下一个处理器
     */
    public void  setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     *  获取处理器等级 视情节是否传参
     * @return 处理器等级
     */
    abstract Level getHandLevel();

    /**
     * 当前处理器的响应
     * @param request 请求
     * @return 响应
     */
    abstract Response response(Request request);


    /**
     * 如果满足处理的条件，则有本处理类来进行处理，否则由nextHandler来处理
     * @param request 请求
     * @return 处理之后的返回
     */
    public final Response handleRequest(Request request){
        Response response = null;
        if (this.getHandLevel().above(request.getLevel())) {
            response = this.response(request);
        }else {
            if (null != this.nextHandler) {
                this.nextHandler.handleRequest(request);
            }else {
                System.out.println("没有合适处理器");
            }
        }
        return response;
    }
}
