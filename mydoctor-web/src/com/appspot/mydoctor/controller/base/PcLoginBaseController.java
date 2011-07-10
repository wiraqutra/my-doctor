package com.appspot.mydoctor.controller.base;

import org.slim3.controller.Navigation;

import com.appspot.mydoctor.enumeration.SessionKeyEnum;
import com.appspot.mydoctor.model.LoginSessionModel;
import com.appspot.mydoctor.util.UrlUtil;

public abstract class PcLoginBaseController extends PcBaseController {

	private LoginSessionModel loginSession;

	@Override
	protected final Navigation run() throws Exception {
		loginSession = sessionScope(SessionKeyEnum.LOGIN_SESSION_KEY.getKey());
		if (loginSession == null || loginSession.getAccount() == null) {
			String requestURL = UrlUtil.getRequestURL(request);
			return redirect("/pc/login?ret=" + requestURL);
		}
		return execute();
	}

	protected abstract Navigation execute() throws Exception;
}
