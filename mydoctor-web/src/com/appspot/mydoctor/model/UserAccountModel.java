package com.appspot.mydoctor.model;

import java.io.Serializable;

import org.slim3.datastore.Model;

import com.appspot.mydoctor.model.base.AccountModel;

@Model(schemaVersion = 1)
public class UserAccountModel extends AccountModel implements Serializable {

	private static final long serialVersionUID = -7730560284318893568L;

	private String tokenKey;

	private String tokenSecret;

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}
}
