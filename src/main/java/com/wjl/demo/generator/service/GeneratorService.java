package com.wjl.demo.generator.service;

import com.wjl.demo.generator.dao.GeneratorDao;
import com.wjl.demo.generator.entity.ColumnEntity;
import com.wjl.demo.generator.entity.TableEntity;
import com.wjl.demo.utils.GenUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 * @author 王加伦
 * @date 2019/1/16
 */
@Service
public class GeneratorService {

    @Autowired
    private GeneratorDao generatorDao;

    /**
     *  查询库中表列表
     * @Param: [map] 表名 ps 可扩展列表查询
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    public List<Map<String, Object>> queryTableList(Map<String, Object> map) {
        return generatorDao.queryTableList(map);
    }

    /**
     *   根据表名查询表信息
     * @param tableName 表名
     * @return com.wjl.demo.generator.entity.TableEntity
    */
    public TableEntity queryTableInfo(String tableName) {
        return generatorDao.queryTableInfo(tableName);
    }

    /**
     *  根据表名查询表中字段信息
     * @param tableName
     * @return List<ColumnEntity>
    */
    public List<ColumnEntity> queryTableColumns(String tableName) {
        return generatorDao.queryTableColumns(tableName);
    }

    /**
     *  生成代码
     * @param tableName
     * @return
     */
    public byte[] generatorCode(String tableName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        //查询表信息
        TableEntity tableEntity = queryTableInfo(tableName);
        //查询列信息
        List<ColumnEntity> columnEntityList = queryTableColumns(tableName);
        //生成代码
        GenUtils.generatorCode(tableEntity, columnEntityList, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

}
