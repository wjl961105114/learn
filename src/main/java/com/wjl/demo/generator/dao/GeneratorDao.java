package com.wjl.demo.generator.dao;

import com.wjl.demo.generator.entity.ColumnEntity;
import com.wjl.demo.generator.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 *  代码生成器
 * @author 王加伦
 * @date 2019/1/16
 */
@Mapper
public interface GeneratorDao {

    /**
     *  查询库中表列表
     * @param map
     * @return
     */
    List<Map<String, Object>> queryTableList(Map<String, Object> map);

    /**
     *  根据表名查询表信息
     * @param tableName 表名
     * @return com.wjl.demo.generator.entity.TableEntity
    */
    TableEntity queryTableInfo(String tableName);

    /**
     *  根据表名查询表中字段信息信息
     * @param tableName 表名
     * @return List<ColumnEntity>
     */
    List<ColumnEntity> queryTableColumns(String tableName);
}
