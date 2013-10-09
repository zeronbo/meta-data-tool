package me.coolcoder.metadata.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import me.coolcoder.metadata.os.PathTool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取配置文件类
 * 
 * @author Zero
 * 
 */
public class Config {

	private static Config config = new Config();
	private static final Logger L = LoggerFactory.getLogger(Config.class);

	// 数据库Driver
	private static String dbConnectionDriver;
	// 数据库连接
	private static String dbConnectionUrl;
	// 数据库用户名
	private static String dbConnectionUsername;
	// 数据库密码
	private static String dbConnectionPassword;
	// 数据库表xml描述文件目录
	private static String xmlDirPath;

	static {
		Properties pro = new Properties();
		String configPath = PathTool.join(PathTool.getUserDir(),
				new String[] { "config.properties" });
		File file = new File(configPath);
		InputStream in = null;
		if (file.exists() && file.isFile()) {
			L.info("读取外部配置文件:" + file.getPath());
			try {
				in = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				L.error("未找到配置文件('config.properties'):" + file.getPath(), e);
			}
		} else {
			in = Config.class.getResourceAsStream("/config.properties");
		}

		try {
			pro.load(in);
		} catch (IOException e) {
			L.error("读取配置文件('config.properties')失败!");
		}

		dbConnectionDriver = pro.getProperty("db.connection.driver_class");
		dbConnectionUrl = pro.getProperty("db.connection.url");
		dbConnectionUsername = pro.getProperty("db.connection.username");
		dbConnectionPassword = pro.getProperty("db.connection.password");
		xmlDirPath = pro.getProperty("xml.dir.path");
	}

	/**
	 * 数据库Driver
	 * 
	 * @return
	 */
	public String getDbConnectionDriver() {
		return dbConnectionDriver;
	}

	/**
	 * 数据库连接URL
	 * 
	 * @return
	 */
	public String getDbConnectionUrl() {
		return dbConnectionUrl;
	}

	/**
	 * 数据库用户名
	 * 
	 * @return
	 */
	public String getDbConnectionUsername() {
		return dbConnectionUsername;
	}

	/**
	 * 
	 * 数据库密码
	 * 
	 * @return
	 */
	public String getDbConnectionPassword() {
		return dbConnectionPassword;
	}

	/**
	 * 数据库表xml描述文件目录
	 * 
	 * @return
	 */
	public String getXmlDirPath() {
		return xmlDirPath;
	}

	public static Config getInit() {
		return config;
	}

	private Config() {

	}
}
