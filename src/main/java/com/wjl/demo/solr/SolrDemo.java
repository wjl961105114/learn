package com.wjl.demo.solr;

import org.springframework.beans.factory.annotation.Value;

/**
 * Solr的Java调用Demo
 *
 * @author 王加伦
 * @date 2019/1/19
 */
public class SolrDemo{

    @Value("${spring.data.solr.zk-host}")
    private String zkHost;

    /** 
     *   导入数据
     * @param  
     * @return void
    */ 
    public void importDataToSolr(){

    }
}
