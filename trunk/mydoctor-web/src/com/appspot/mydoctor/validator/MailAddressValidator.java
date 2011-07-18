package com.appspot.mydoctor.validator;

import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.slim3.controller.validator.AbstractValidator;
import org.slim3.util.ApplicationMessage;

public class MailAddressValidator extends AbstractValidator {

	public static MailAddressValidator INSTANCE = new MailAddressValidator();

	public String validate(Map<String, Object> parameters, String name) {
		try {
			Object value = parameters.get(name);
			if (value instanceof String) {
				String email = (String) value;
				InternetAddress inaddr = new InternetAddress(email, true);
				return null;
			}
		} catch (AddressException e) {

		}
		return ApplicationMessage.get(getMessageKey(), getLabel(name));
	}

	@Override
	protected String getMessageKey() {

		return "validator.mailaddress";
	}

}
