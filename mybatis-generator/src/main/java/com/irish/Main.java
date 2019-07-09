package com.irish;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class  Main {

	public static void main(String[] args) throws Exception {
		//生成之前，请确认src/main/resources/mapper这个目录存在
		 new Main().generateArtifacts();
	}
	
	@SuppressWarnings("unused")
	private  void generateArtifacts() throws Exception {
		System.out.println("--------------------start-------------------------------");
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(this.getClass().getResourceAsStream("/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println(warnings.toString());
		System.out.println("--------------------Done-------------------------------");
	}
}
