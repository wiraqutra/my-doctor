package com.appspot.mydoctor.util;

import java.io.StringWriter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class MailUtil {

	private static Logger LOGGER = Logger.getLogger(MailUtil.class);

	public static String createMailBody(String templateName, Map<String, String> params) {
		String result = "";
		try {
			Velocity.init("WEB-INF/velocity.properties");
			VelocityContext context = new VelocityContext();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				context.put(entry.getKey(), entry.getValue());
			}
			StringWriter sw = new StringWriter();
			Template template = Velocity.getTemplate(templateName, "UTF-8");
			template.merge(context, sw);
			result = sw.toString();
			sw.flush();
			sw.close();
		} catch (Exception e) {
			LOGGER.warn("velocity error", e);
		}
		return result;
	}
}
