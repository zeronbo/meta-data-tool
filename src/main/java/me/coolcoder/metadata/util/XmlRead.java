package me.coolcoder.metadata.util;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.coolcoder.metadata.config.Config;
import me.coolcoder.metadata.exception.MetaDataToolException;


public class XmlRead {
	
	private static final Logger L = LoggerFactory.getLogger(XmlRead.class);
	
	/**
	 * 获取数据库表描述xml文件名
	 * @return
	 * @throws MetaDataToolException
	 */
	private List<String> getXmlFileName() throws MetaDataToolException {
		File file = new File(Config.getInit().getXmlDirPath());
		if (!file.exists() || file.isFile()) {
			throw new MetaDataToolException("未找到数据库表描述xml文件所在目录:" + Config.getInit().getXmlDirPath());
		}
		
		String[] listFileName = file.list();
		for (String s : listFileName) {
			L.debug("文件名:" + s);
		}
		return null;
	}
	
	public static void main(String[] args) throws MetaDataToolException {
		new XmlRead().getXmlFileName();
	}
	
	
}
