package com.appspot.mydoctor.auth;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.mydoctor.enumeration.AuthActionEnum;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.model.base.AccountModel;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class GoogleOAuth extends BaseAuth {

	@Override
	public AccountModel getUser() {
		return user;
	}

	@Override
	public AuthActionEnum auth(HttpServletRequest request, HttpServletResponse response, TerminalTypeEnum terminalType) {
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn()) {
			return AuthActionEnum.SUCCESS;
		} else {
			try {
				response.sendRedirect(userService.createLoginURL(request.getRequestURI()));
			} catch (IOException e) {
				logger.log(Level.SEVERE, "auth error", e);
			}
		}
		return AuthActionEnum.FAILED;
	}
}
