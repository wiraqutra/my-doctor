package com.appspot.mydoctor.controller.medical;

import org.slim3.controller.Navigation;

import com.appspot.mydoctor.auth.GoogleOAuth;
import com.appspot.mydoctor.controller.base.PcBaseController;
import com.appspot.mydoctor.enumeration.OAuthServiceEnum;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;

public class LoginController extends PcBaseController {

	private String service;

	@Override
	public Navigation run() throws Exception {
		service = asString("sv");
		OAuthServiceEnum serviceEnum = OAuthServiceEnum.getInstance(service);

		GoogleOAuth auth = new GoogleOAuth();
		System.out.println(auth.auth(request, response, TerminalTypeEnum.PC));
		return forward("medical/login.jsp");
	}
}
