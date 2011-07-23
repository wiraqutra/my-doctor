package com.appspot.mydoctor.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import twitter4j.Twitter;
import twitter4j.auth.RequestToken;

import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.model.base.AuthSessionModel;

@Model(schemaVersion = 1)
public class TwitterAuthSessionModel extends AuthSessionModel {

	private static final long serialVersionUID = 6583185315862703275L;

	public static final int SESSION_KEY_LENGTH = 16;

	@Attribute(lob = true)
	private Twitter twitter;

	@Attribute(lob = true)
	private RequestToken requestToken;

	private TerminalTypeEnum terminalType;

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public RequestToken getRequestToken() {
		return requestToken;
	}

	public void setRequestToken(RequestToken requestToken) {
		this.requestToken = requestToken;
	}

	public TerminalTypeEnum getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(TerminalTypeEnum terminalType) {
		this.terminalType = terminalType;
	}

}
