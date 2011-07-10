package com.appspot.mydoctor.service;

import java.util.Date;

import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.model.TokenModel;
import com.google.appengine.api.datastore.Key;

public class TokenCheckService {

	public static final long TOKEN_EXPIRE_TIME_SEC = 60 * 60;

	public String getToken() {
		TokenModel model = new TokenModel();
		model.setExpire(new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME_SEC * 1000));
		Key key = Datastore.put(model);
		return Datastore.keyToString(key);
	}

	public boolean isValidToken(String tokenKey) {
		boolean result = false;
		TokenModel model = Datastore.get(TokenModel.class, Datastore.stringToKey(tokenKey));
		if (model != null) {
			if (System.currentTimeMillis() < model.getExpire().getTime()) {
				result = true;
			}
			Datastore.delete(model.getKey());
		}
		return result;
	}
}
