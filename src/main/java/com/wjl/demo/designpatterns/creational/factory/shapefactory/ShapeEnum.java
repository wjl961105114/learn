package com.wjl.demo.designpatterns.creational.factory.shapefactory;

/**
 * 形状枚举类
 *
 * @author wangJiaLun
 * @date 2019-04-08
 **/
public enum ShapeEnum {

    /**
     *  圆
     */
    CIRCLE(1,"圆"),

    /**
     *  长方形
     */
    RECTANGLE(2, "长方形"),

    /**
     *  正方形
     */
    SQUARE(3, "正方形");

    /**
     * 代码
     */
    private Integer code;

    /**
     *  描述
     */
    private String desc;

    /**
     * Gets the value of code
     *
     * @return the value of code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Gets the value of desc
     *
     * @return the value of desc
     */
    public String getDesc() {
        return desc;
    }

    ShapeEnum(Integer code, String desc) {
        this.code=code;
        this.desc=desc;
    }

    public static ShapeEnum getByCode(Integer code){
        if (null == code) {
            return null;
        }

        for (ShapeEnum element : ShapeEnum.values()) {
            if (code.longValue() == code.longValue()) {
                return element;
            }
        }

        return null;
    }
}
