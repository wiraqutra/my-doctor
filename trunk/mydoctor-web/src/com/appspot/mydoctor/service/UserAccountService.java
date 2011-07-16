package com.appspot.mydoctor.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slim3.datastore.Datastore;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.appspot.mydoctor.constant.MydoctorConstant;
import com.appspot.mydoctor.enumeration.OAuthServiceEnum;
import com.appspot.mydoctor.exception.InvalidArgumentException;
import com.appspot.mydoctor.exception.TimeoutException;
import com.appspot.mydoctor.exception.login.DuplicateEmailException;
import com.appspot.mydoctor.meta.UserAccountModelMeta;
import com.appspot.mydoctor.model.LoginSessionModel;
import com.appspot.mydoctor.model.TwitterAccessModel;
import com.appspot.mydoctor.model.TwitterAuthSessionModel;
import com.appspot.mydoctor.model.UserAccountModel;
import com.appspot.mydoctor.util.DateUtil;
import com.appspot.mydoctor.util.UniqueEntityUtil;
import com.google.appengine.api.datastore.Key;

public class UserAccountService {

	public boolean register(String name, String email, String plainPassword) throws DuplicateEmailException, InvalidArgumentException {
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(email) || StringUtils.isEmpty(plainPassword)) {
			throw new InvalidArgumentException();
		}
		UserAccountModelMeta meta = UserAccountModelMeta.get();
		List<Key> list = Datastore.query(meta).filter(meta.loginId.equal(email)).asKeyList();
		if (list != null && list.size() > 0) {
			throw new DuplicateEmailException();
		}
		UserAccountModel model = new UserAccountModel();
		model.setEmail(email);
		model.setNickName(name);
		model.setLoginId(email);
		model.setLoginPasswordHash(DigestUtils.sha512Hex(plainPassword));
		Datastore.put(model);
		return true;
	}

	public boolean register(String name, String email, String tokenKey, String tokenSecret) {
		return false;
	}

	public String createLoginSession(TwitterAuthSessionModel tas, String verifier) throws TwitterException, TimeoutException {
		LoginSessionModel lm = new LoginSessionModel();
		UserAccountModel um = new UserAccountModel();
		Twitter tw = tas.getTwitter();
		RequestToken rtoken = tas.getRequestToken();
		AccessToken atoken = tw.getOAuthAccessToken(rtoken, verifier);
		TwitterAccessModel tam = TwitterAccessModel.build(atoken.getUserId(), atoken.getScreenName(), atoken.getToken(), atoken.getTokenSecret());
		um.setEmail(tas.getEmail());
		um.setNickName(tas.getNickName());
		um.setLoginId(tas.getEmail());
		um.setOauthType(OAuthServiceEnum.TWITTER);
		um.setTwitterAccessModel(tam);
		lm.setAccount(um);
		lm.setExpireDate(DateUtil.getExpireDateMinutes(MydoctorConstant.getSessionExpireMinutes()));
		lm.setSessionKey(UniqueEntityUtil.getSessionKey(LoginSessionModel.class.getSimpleName(), LoginSessionModel.SESSION_KEY_LENGTH));
		Datastore.put(lm);
		return lm.getSessionKey();
	}
}
