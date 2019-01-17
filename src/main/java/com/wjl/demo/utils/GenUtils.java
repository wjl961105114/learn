/**
 * Copyright 2018 工程点点 http://www.koncendy.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wjl.demo.utils;

import com.wjl.demo.exception.BaseException;
import com.wjl.demo.generator.entity.ColumnEntity;
import com.wjl.demo.generator.entity.TableEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *  代码生成器
 * @author 王加伦
 * @date 2019/1/16
 */
public class GenUtils {

	public static List<String> getTemplates(){
		List<String> templates = new ArrayList<String>();
		templates.add("generator/template/Entity.java.vm");
		templates.add("generator/template/Dao.java.vm");
		templates.add("generator/template/Dao.xml.vm");
		templates.add("generator/template/Service.java.vm");
		templates.add("generator/template/ServiceImpl.java.vm");
		templates.add("generator/template/Controller.java.vm");
		return templates;
	}
	
	/**
	 * 生成代码
	 */
	public static void generatorCode(TableEntity tableEntity,List<ColumnEntity> columnEntityList, ZipOutputStream zip){
		//配置信息
		Configuration config = getConfig();
		boolean hasBigDecimal = false;

		//表名转换成Java类名
		String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
		tableEntity.setClassUpName(StringUtils.capitalize(className));
		tableEntity.setClassLowName(StringUtils.uncapitalize(className));

		//列信息
		columnEntityList.forEach(columnEntity -> {
			//列名转换成Java属性名
			String attrName = columnToJava(columnEntity.getColumnName());
			columnEntity.setFieldUpName(attrName);
			columnEntity.setFieldLowName(StringUtils.uncapitalize(attrName));
			// 列的数据类型，转换成Java类型
			String attrType = config.getString(columnEntity.getColumnType(), "unknowType");
			columnEntity.setFieldType(attrType);
			//是否主键
			if("PRI".equalsIgnoreCase(columnEntity.getColumnKey()) && tableEntity.getPk() == null){
				tableEntity.setPk(columnEntity);
			}
		});

		tableEntity.setColumns(columnEntityList);
		
		//没主键，则第一个字段为主键
		if(tableEntity.getPk() == null){
			tableEntity.setPk(tableEntity.getColumns().get(0));
		}
		
		//设置velocity资源加载器
		Properties prop = new Properties();  
		prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");  
		Velocity.init(prop);

		String mainPath = config.getString("mainPath" );
		mainPath = StringUtils.isBlank(mainPath) ? "com.wjl" : mainPath;
		
		//封装模板数据
		Map<String, Object> map = new HashMap<>();
		map.put("tableName", tableEntity.getTableName());
		map.put("tableComment", tableEntity.getTableComment());
		map.put("pk", tableEntity.getPk());
		map.put("classUpName", tableEntity.getClassUpName());
		map.put("classLowName", tableEntity.getClassLowName());
		map.put("pathName", tableEntity.getClassLowName().toLowerCase());
		map.put("columns", tableEntity.getColumns());
		map.put("hasBigDecimal", hasBigDecimal);
		map.put("mainPath", mainPath);
		map.put("package", config.getString("package" ));
		map.put("moduleName", config.getString("moduleName" ));
		map.put("author", config.getString("author"));
		map.put("email", config.getString("email"));
		map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);
        
        //获取模板列表
		List<String> templates = getTemplates();
		for(String template : templates){
			//渲染模板
			StringWriter sw = new StringWriter();
			Template tpl = Velocity.getTemplate(template, "UTF-8");
			tpl.merge(context, sw);
			
			try {
				//添加到zip
				zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassUpName(), config.getString("package"), config.getString("moduleName"))));
				IOUtils.write(sw.toString(), zip, "UTF-8");
				IOUtils.closeQuietly(sw);
				zip.closeEntry();
			} catch (IOException e) {
				throw new BaseException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
			}
		}
	}
	
	
	/**
	 * 列名转换成Java属性名
	 */
	public static String columnToJava(String columnName) {
		return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
	}
	
	/**
	 * 表名转换成Java类名
	 */
	public static String tableToJava(String tableName, String tablePrefix) {
		if(StringUtils.isNotBlank(tablePrefix)){
			tableName = tableName.replace(tablePrefix, "");
		}
		return columnToJava(tableName);
	}
	
	/**
	 * 获取配置信息
	 */
	public static Configuration getConfig(){
		try {
			return new PropertiesConfiguration("generator/generator.properties");
		} catch (ConfigurationException e) {
			throw new BaseException("获取配置文件失败，", e);
		}
	}

	/**
	 * 获取文件名
	 */
	public static String getFileName(String template, String className, String packageName, String moduleName) {
		String packagePath = "main" + File.separator + "java" + File.separator;
		if (StringUtils.isNotBlank(packageName)) {
			packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
		}

		if (template.contains("Entity.java.vm" )) {
			return packagePath + "entity" + File.separator + className + "Entity.java";
		}

		if (template.contains("Dao.java.vm" )) {
			return packagePath + "dao" + File.separator + className + "Dao.java";
		}

		if (template.contains("Service.java.vm" )) {
			return packagePath + "service" + File.separator + className + "Service.java";
		}

		if (template.contains("ServiceImpl.java.vm" )) {
			return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
		}

		if (template.contains("Controller.java.vm" )) {
			return packagePath + "controller" + File.separator + className + "Controller.java";
		}

		if (template.contains("Dao.xml.vm" )) {
			return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Dao.xml";
		}

		return null;
	}
}
