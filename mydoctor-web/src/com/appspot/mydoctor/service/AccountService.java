package com.appspot.mydoctor.service;

import org.apache.log4j.Logger;
import org.slim3.datastore.Datastore;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.appspot.mydoctor.meta.oauth.TwitterAccessModelMeta;
import com.appspot.mydoctor.model.base.AccountModel;
import com.appspot.mydoctor.model.oauth.TwitterAccessModel;

public class AccountService {

	private static Logger LOGGER = Logger.getLogger(AccountService.class);

	public AccountModel getLoginUser(TwitterAccessModel tam) {
		if (tam == null) {
			return null;
		}
		TwitterAccessModelMeta meta = TwitterAccessModelMeta.get();
		TwitterAccessModel registered = Datastore.query(meta).filter(meta.userId.equal(tam.getUserId())).asSingle();
		if (registered != null) {
			AccountModel am = registered.getAccountModelRef().getModel();
			return am;
		}
		return null;
	}

	public TwitterAccessModel createTwitterAccessModel(Twitter tw, RequestToken rtoken, String verifier) {
		try {
			AccessToken atoken = tw.getOAuthAccessToken(rtoken, verifier);
			TwitterAccessModel tam = TwitterAccessModel.build(atoken.getUserId(), atoken.getScreenName(), atoken.getToken(), atoken.getTokenSecret());
			return tam;
		} catch (TwitterException e) {
			LOGGER.warn("twitter auth failed", e);
		}
		return null;
	}
}
