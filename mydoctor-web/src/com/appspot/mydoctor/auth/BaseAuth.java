package com.appspot.mydoctor.auth;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.appspot.mydoctor.enumeration.SessionKeyEnum;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.model.LoginSessionModel;
import com.appspot.mydoctor.model.base.AccountModel;

public abstract class BaseAuth {

	protected static final Logger logger = Logger.getLogger(BaseAuth.class.getName());

	protected AccountModel user = null;

	public abstract AccountModel getUser();

	public abstract boolean auth(HttpServletRequest request, HttpServletResponse response, TerminalTypeEnum terminalType);

	protected LoginSessionModel getSessionModel(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			LoginSessionModel model = (LoginSessionModel) session.getAttribute(SessionKeyEnum.LOGIN_SESSION_KEY.getKey());
			return model;
		}
		return null;
	}
}
