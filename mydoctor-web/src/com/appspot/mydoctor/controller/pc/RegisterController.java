package com.appspot.mydoctor.controller.pc;

import java.io.IOException;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.appspot.mydoctor.controller.base.PcBaseController;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.exception.RandomKeyCreateTimeoutException;
import com.appspot.mydoctor.exception.login.DuplicateEmailException;
import com.appspot.mydoctor.service.RegisterService;
import com.appspot.mydoctor.validator.MailAddressValidator;

public class RegisterController extends PcBaseController {

	private String email;
	private String nickName;
	private String cmd;

	@Override
	public Navigation run() throws Exception {
		cmd = requestScope("cmd");
		email = requestScope("email");
		nickName = requestScope("nickName");

		if ("submit".equals(cmd) && validate()) {
			RegisterService service = new RegisterService();
			try {
				service.register(nickName, email, TerminalTypeEnum.PC);
			} catch (DuplicateEmailException e) {

			} catch (IOException e) {

			} catch (RandomKeyCreateTimeoutException e) {

			}
			return forward("register_finish.jsp");
		}
		return forward("register.jsp");
	}

	protected boolean validate() {

		Validators v = new Validators(request);
		v.add("email", v.required());
		v.add("nickName", v.required());
		v.add("email", MailAddressValidator.INSTANCE);
		return v.validate();
	}
}
