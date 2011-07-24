package com.appspot.mydoctor.auth;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.enumeration.AuthActionEnum;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.meta.account.UserAccountModelMeta;
import com.appspot.mydoctor.model.account.UserAccountModel;
import com.appspot.mydoctor.model.base.AccountModel;

public class EmailAuth extends BaseAuth {

	@Override
	public AccountModel getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthActionEnum auth(HttpServletRequest request, HttpServletResponse response, TerminalTypeEnum terminalType) {
		String email = request.getParameter("email");
		String password = request.getParameter("passwd");
		if (StringUtils.isNotEmpty(email)) {
			UserAccountModelMeta meta = UserAccountModelMeta.get();
			List<UserAccountModel> list = Datastore.query(meta).filter(meta.loginId.equal(email)).asList();
			if (list != null && list.size() == 1) {
				UserAccountModel model = list.get(0);
				if (DigestUtils.sha512Hex(password).equals(model.getLoginPasswordHash())) {
					return AuthActionEnum.SUCCESS;
				}
			}
		}
		return AuthActionEnum.FAILED;
	}

}
