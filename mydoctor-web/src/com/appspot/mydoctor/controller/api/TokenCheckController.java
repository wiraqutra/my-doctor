package com.appspot.mydoctor.controller.api;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.mydoctor.service.TokenCheckService;
import com.google.gson.Gson;

public class TokenCheckController extends Controller {

	@Override
	public Navigation run() throws Exception {
		TokenCheckService service = new TokenCheckService();
		String tokenKey = service.getToken();
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("token", tokenKey);

		String type = asString("type");
		String fileName = "token.json";
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		if ("xml".equals(type)) {
			response.setContentType("application/xml; charset=UTF-8");
		} else {
			response.setContentType("application/json; charset=UTF-8");
			Gson gson = new Gson();
			PrintWriter wr = response.getWriter();
			wr.write(gson.toJson(map));
			wr.flush();
		}
		return null;
	}
}
