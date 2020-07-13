package com.myown.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {

    public static void main(String[] args) {
        try{
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            // mybatis-generator.xml配置文件放在resources目录里。
            String configFilePath = MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").getFile();
            File configFile = new File(configFilePath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
