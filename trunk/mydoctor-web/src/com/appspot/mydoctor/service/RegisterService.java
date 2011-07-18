package com.appspot.mydoctor.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.constant.MydoctorConstant;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.exception.TimeoutException;
import com.appspot.mydoctor.model.TemporaryAccountModel;
import com.appspot.mydoctor.util.DateUtil;
import com.appspot.mydoctor.util.MailUtil;
import com.appspot.mydoctor.util.UniqueEntityUtil;
import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailService.Message;
import com.google.appengine.api.mail.MailServiceFactory;

public class RegisterService {

	public void register(String nickName, String email, TerminalTypeEnum terminalType) throws TimeoutException, IOException {
		String accessKey = UniqueEntityUtil.getMailAccessKey();
		TemporaryAccountModel model = new TemporaryAccountModel();
		model.setAccessKey(accessKey);
		model.setNickName(nickName);
		model.setEmail(email);
		model.setExpireDate(DateUtil.getExpireDateMinutes(30));
		model.setTerminalType(TerminalTypeEnum.PC);
		Datastore.put(model);

		MailService mail = MailServiceFactory.getMailService();
		Message message = new Message();
		message.setTo(email);
		message.setSubject("my-doctor新規登録確認メール");
		Map<String, String> params = new HashMap<String, String>();
		params.put("nickName", nickName);
		params.put("accessKey", accessKey);

		switch (terminalType) {
		case PC:
			message.setTextBody(MailUtil.createMailBody("pc/confirm_register.tmpl", params));
			break;
		case MOBILE:
			message.setTextBody(MailUtil.createMailBody("m/confirm_register.tmpl", params));
			break;
		case DS:
			message.setTextBody(MailUtil.createMailBody("ds/confirm_register.tmpl", params));
			break;
		case SMARTPHONE:
			message.setTextBody(MailUtil.createMailBody("sp/confirm_register.tmpl", params));
			break;
		}

		message.setSender(MydoctorConstant.getSystemFromMailAddress());
		mail.send(message);
	}
}
