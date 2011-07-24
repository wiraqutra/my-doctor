package com.appspot.mydoctor.model.oauth;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelRef;
import org.slim3.datastore.Model;

import com.appspot.mydoctor.model.base.AccountModel;
import com.appspot.mydoctor.model.base.OAuthAccessModel;

@Model(schemaVersion = 1)
public class TwitterAccessModel extends OAuthAccessModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private String screenName;
	private String accessToken;
	private String accessTokenSecret;

	@Attribute(persistent = false)
	private InverseModelRef<AccountModel, TwitterAccessModel> accountModelRef = new InverseModelRef<AccountModel, TwitterAccessModel>(AccountModel.class, "twitterAccessModelRef", this);

	public static TwitterAccessModel build(Long userId, String screenName, String accessToken, String accessTokenSecret) {
		TwitterAccessModel model = new TwitterAccessModel();
		model.setUserId(userId);
		model.setScreenName(screenName);
		model.setAccessToken(accessToken);
		model.setAccessTokenSecret(accessTokenSecret);
		return model;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}

	public InverseModelRef<AccountModel, TwitterAccessModel> getAccountModelRef() {
		return accountModelRef;
	}

}
