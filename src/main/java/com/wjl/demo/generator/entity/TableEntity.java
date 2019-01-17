package com.wjl.demo.generator.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 表结构
 * @author 王加伦
 * @date  2019/1/14
 */
@Alias("table")
public class TableEntity {

    /**
     *  表名
     */
    private String tableName;

    /**
     *  表备注
     */
    private String tableComment;

    /**
     *  表中主键
     */
    private ColumnEntity pk;

    /**
     *  表中非主键字段集合
     */
    private List<ColumnEntity> columns;

    /**
     *  类名(首字母小写)
     */
    private String classLowName;

    /**
     *  类名(首字母大写)
     */
    private String classUpName;

    /**
     * Gets the value of tableName.
     *
     * @return the value of tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the tableName.
     *
     * <p>You can use getTableName() to get the value of tableName</p>
     *
     * @param tableName tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Gets the value of tableComment.
     *
     * @return the value of tableComment
     */
    public String getTableComment() {
        return tableComment;
    }

    /**
     * Sets the tableComment.
     *
     * <p>You can use getTableComment() to get the value of tableComment</p>
     *
     * @param tableComment tableComment
     */
    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    /**
     * Gets the value of pk.
     *
     * @return the value of pk
     */
    public ColumnEntity getPk() {
        return pk;
    }

    /**
     * Sets the pk.
     *
     * <p>You can use getPk() to get the value of pk</p>
     *
     * @param pk pk
     */
    public void setPk(ColumnEntity pk) {
        this.pk = pk;
    }

    /**
     * Gets the value of columns.
     *
     * @return the value of columns
     */
    public List<ColumnEntity> getColumns() {
        return columns;
    }

    /**
     * Sets the columns.
     *
     * <p>You can use getColumns() to get the value of columns</p>
     *
     * @param columns columns
     */
    public void setColumns(List<ColumnEntity> columns) {
        this.columns = columns;
    }

    /**
     * Gets the value of classLowName.
     *
     * @return the value of classLowName
     */
    public String getClassLowName() {
        return classLowName;
    }

    /**
     * Sets the classLowName.
     *
     * <p>You can use getClassLowName() to get the value of classLowName</p>
     *
     * @param classLowName classLowName
     */
    public void setClassLowName(String classLowName) {
        this.classLowName = classLowName;
    }

    /**
     * Gets the value of classUpName.
     *
     * @return the value of classUpName
     */
    public String getClassUpName() {
        return classUpName;
    }

    /**
     * Sets the classUpName.
     *
     * <p>You can use getClassUpName() to get the value of classUpName</p>
     *
     * @param classUpName classUpName
     */
    public void setClassUpName(String classUpName) {
        this.classUpName = classUpName;
    }
}
