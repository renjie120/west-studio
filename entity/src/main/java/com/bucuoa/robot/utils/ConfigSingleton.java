package com.bucuoa.robot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigSingleton {
	static Logger logger = LoggerFactory.getLogger(ConfigSingleton.class);

	// 配置文件
	private Properties myProps = null;

	// 设立静态变量，直接创建实例
	private static ConfigSingleton mySingleton = null;

	private static class Singleton {
		public static ConfigSingleton getInstance() {
			ConfigSingleton mySingleton = new ConfigSingleton();
			return mySingleton;
		}
	}

	// 获取从配置文件取得的信息
	public String getProperties(String key) {
		return myProps.getProperty(key);
	}

	public Integer getIntegerProperties(String key) {
		String property = getProperties(key);

		int parseInt;
		try {
			parseInt = Integer.parseInt(property);
		} catch (NumberFormatException e) {
			parseInt = 0;
		}

		return parseInt;
	}

	public Double getDoubleProperties(String key) {
		String property = getProperties(key);

		double parseInt;
		try {
			parseInt = Double.parseDouble(property);
		} catch (NumberFormatException e) {
			parseInt = 0;
		}

		return parseInt;
	}

	private InputStream getFileStream(String url) {
		InputStream in = getClass().getResourceAsStream(url);

		return in;
	}

	private ConfigSingleton() {
		// 私有化构造函数

		myProps = new Properties();
		InputStream in = getFileStream("/important.properties");
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(in, "utf-8"));

			myProps.load(bf);
		} catch (IOException e) {
			logger.error("构造配置文件单例失败", e);
		}

	}

	// 开放一个公有方法，判断是否已经存在实例，有返回，没有新建一个在返回
	public static ConfigSingleton getInstance() {
		ConfigSingleton s1 = null;
		if (mySingleton == null) {
			logger.info("-->没有实例，调用内部类方法返回实例");
			mySingleton = ConfigSingleton.Singleton.getInstance();
		}
		s1 = mySingleton;
		return s1;
	}

}