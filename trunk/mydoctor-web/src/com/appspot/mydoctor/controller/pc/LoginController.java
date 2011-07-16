package com.appspot.mydoctor.controller.pc;

import org.apache.commons.lang.StringUtils;
import org.slim3.controller.Navigation;

import com.appspot.mydoctor.auth.BaseAuth;
import com.appspot.mydoctor.auth.EmailAuth;
import com.appspot.mydoctor.auth.FacebookOAuth;
import com.appspot.mydoctor.auth.GoogleOAuth;
import com.appspot.mydoctor.auth.TwitterOAuth;
import com.appspot.mydoctor.controller.base.PcBaseController;
import com.appspot.mydoctor.enumeration.OAuthServiceEnum;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;

public class LoginController extends PcBaseController {

	@Override
	public Navigation run() throws Exception {
		String ret = (String) requestScope("ret");
		if (StringUtils.isEmpty(ret)) {
			ret = "/";
		}
		String m = requestScope("m");
		BaseAuth auth = null;
		OAuthServiceEnum oauthEnum = OAuthServiceEnum.getInstance(m);
		if (oauthEnum != null) {
			switch (oauthEnum) {
			case TWITTER:
				auth = new TwitterOAuth();
				break;
			case GOOGLE:
				auth = new GoogleOAuth();
				break;
			case FACEBOOK:
				auth = new FacebookOAuth();
				break;
			case EMAIL:
				auth = new EmailAuth();
				break;

			}
		}

		if (auth != null) {
			if (auth.auth(request, response, TerminalTypeEnum.PC)) {
				return redirect(ret);
			}
		}
		requestScope("ret", ret);
		return forward("login.jsp");
	}
}
