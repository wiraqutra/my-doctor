package com.appspot.mydoctor.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {

	private static Logger LOGGER = Logger.getLogger(PropertiesUtil.class);

	private static Properties oauthProperties;

	public static Properties getOauthProperties() {
		if (oauthProperties == null) {
			try {
				oauthProperties = new Properties();
				oauthProperties.load(new FileInputStream("WEB-INF/oauth.properties"));
			} catch (FileNotFoundException e) {
				LOGGER.fatal("oauth.properties not found", e);
			} catch (IOException e) {
				LOGGER.fatal("oauth.properties not found", e);
			}
		}
		return oauthProperties;
	}
}
