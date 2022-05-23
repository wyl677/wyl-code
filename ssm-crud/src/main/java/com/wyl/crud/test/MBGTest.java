package com.wyl.crud.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther yanl.wang
 * @date 2022/5/21
 **/
public class MBGTest {
    public static void main(String[] args) throws Exception {


        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String path = System.getProperty("user.dir");
        path = path+File.separator+"ssm-crud"+File.separator+"mbg.xml";
        File configFile = new File(path);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }
}
