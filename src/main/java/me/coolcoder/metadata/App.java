package me.coolcoder.metadata;

import me.coolcoder.metadata.config.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {
	
	private static final Logger L = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		L.info("Hello World");
		L.debug("DEBUG:Hello World!");
		
		L.info("driver:" + Config.getInit().getDbConnectionDriver());
		L.info("url:" + Config.getInit().getDbConnectionUrl());
		L.info("username:" + Config.getInit().getDbConnectionUsername());
		L.info("password:" + Config.getInit().getDbConnectionPassword());
	} 
}
