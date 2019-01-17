package com.wjl.demo.generator.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Description 字段属性
 * @Author 王加伦
 * @Date 2019/1/14
 */
@Alias("column")
public class ColumnEntity {

    /**
     *  列名
     */
    private String columnName;
    /**
     *  列类型
     */
    private String columnType;
    /**
     *  列备注
     */
    private String columnComment;
    /**
     *  表中主键
     */
    private String columnKey;

    /**
     *  字段名(首字母小写)
     */
    private String fieldLowName;

    /**
     *  字段名(首字母大写)
     */
    private String fieldUpName;

    /**
     *  字段类型
     */
    private String fieldType;

    /**
     * Gets the value of columnName.
     *
     * @return the value of columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Sets the columnName.
     *
     * <p>You can use getColumnName() to get the value of columnName</p>
     *
     * @param columnName columnName
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Gets the value of columnType.
     *
     * @return the value of columnType
     */
    public String getColumnType() {
        return columnType;
    }

    /**
     * Sets the columnType.
     *
     * <p>You can use getColumnType() to get the value of columnType</p>
     *
     * @param columnType columnType
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    /**
     * Gets the value of columnComment.
     *
     * @return the value of columnComment
     */
    public String getColumnComment() {
        return columnComment;
    }

    /**
     * Sets the columnComment.
     *
     * <p>You can use getColumnComment() to get the value of columnComment</p>
     *
     * @param columnComment columnComment
     */
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    /**
     * Gets the value of columnKey.
     *
     * @return the value of columnKey
     */
    public String getColumnKey() {
        return columnKey;
    }

    /**
     * Sets the columnKey.
     *
     * <p>You can use getColumnKey() to get the value of columnKey</p>
     *
     * @param columnKey columnKey
     */
    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    /**
     * Gets the value of fieldLowName.
     *
     * @return the value of fieldLowName
     */
    public String getFieldLowName() {
        return fieldLowName;
    }

    /**
     * Sets the fieldLowName.
     *
     * <p>You can use getFieldLowName() to get the value of fieldLowName</p>
     *
     * @param fieldLowName fieldLowName
     */
    public void setFieldLowName(String fieldLowName) {
        this.fieldLowName = fieldLowName;
    }

    /**
     * Gets the value of fieldUpName.
     *
     * @return the value of fieldUpName
     */
    public String getFieldUpName() {
        return fieldUpName;
    }

    /**
     * Sets the fieldUpName.
     *
     * <p>You can use getFieldUpName() to get the value of fieldUpName</p>
     *
     * @param fieldUpName fieldUpName
     */
    public void setFieldUpName(String fieldUpName) {
        this.fieldUpName = fieldUpName;
    }

    /**
     * Gets the value of fieldType.
     *
     * @return the value of fieldType
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Sets the fieldType.
     *
     * <p>You can use getFieldType() to get the value of fieldType</p>
     *
     * @param fieldType fieldType
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }
}
