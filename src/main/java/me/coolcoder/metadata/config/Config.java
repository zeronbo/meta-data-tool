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
 * @author Zero
 *
 */
public class Config {

	private static Config config = new Config();
	private static final Logger L = LoggerFactory.getLogger(Config.class);

	private static String dbConnectionDriver;
	private static String dbConnectionUrl;
	private static String dbConnectionUsername;
	private static String dbConnectionPassword;

	static {
		Properties pro = new Properties();
		String configPath = PathTool.join(PathTool.getUserDir(), new String[]{"config.properties"});
		File file = new File(configPath);
		InputStream in = null;
		if(file.exists() && file.isFile()) {
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
	}

	public String getDbConnectionDriver() {
		return dbConnectionDriver;
	}

	public String getDbConnectionUrl() {
		return dbConnectionUrl;
	}

	public String getDbConnectionUsername() {
		return dbConnectionUsername;
	}

	public String getDbConnectionPassword() {
		return dbConnectionPassword;
	}

	public static Config getInit() {
		return config;
	}

	private Config() {
		
	}
}
