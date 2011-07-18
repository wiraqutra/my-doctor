package com.appspot.mydoctor.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.mydoctor.enumeration.AuthActionEnum;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.model.base.AccountModel;

public class FacebookOAuth extends BaseAuth {

	@Override
	public AccountModel getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthActionEnum auth(HttpServletRequest request, HttpServletResponse response, TerminalTypeEnum terminalType) {

		return AuthActionEnum.FAILED;
	}

}
