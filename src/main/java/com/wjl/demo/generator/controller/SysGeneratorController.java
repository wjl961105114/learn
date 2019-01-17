package com.wjl.demo.generator.controller;

import com.wjl.demo.generator.service.GeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  代码生成器
 * @author 王加伦
 * @date 2019/1/16
 */
@Controller
@RequestMapping("/generator")
public class SysGeneratorController {

	@Autowired
	private GeneratorService generatorService;

	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(String  tableName, HttpServletResponse response) throws IOException{

		byte[] data = generatorService.generatorCode(tableName);
		
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\""+tableName+".zip\"");
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());
	}
}
