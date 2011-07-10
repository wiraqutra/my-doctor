package com.appspot.mydoctor.controller.pc;

import org.slim3.controller.Navigation;

import com.appspot.mydoctor.auth.BaseAuth;
import com.appspot.mydoctor.auth.FacebookOAuth;
import com.appspot.mydoctor.auth.GoogleOAuth;
import com.appspot.mydoctor.auth.TwitterOAuth;
import com.appspot.mydoctor.controller.base.PcBaseController;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;

public class LoginController extends PcBaseController {

	@Override
	public Navigation run() throws Exception {
		String m = requestScope("m");
		BaseAuth auth = null;
		if ("gl".equals(m)) {
			auth = new GoogleOAuth();
		} else if ("tw".equals(m)) {
			auth = new TwitterOAuth();
		} else if ("fa".equals(m)) {
			auth = new FacebookOAuth();
		}
		if (auth != null) {
			if (auth.auth(request, response, TerminalTypeEnum.PC)) {

			}
		}
		requestScope("ret", requestScope("ret"));
		return forward("login.jsp");
	}
}
