package com.appspot.mydoctor.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.slim3.datastore.Datastore;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import com.appspot.mydoctor.constant.MydoctorConstant;
import com.appspot.mydoctor.enumeration.AuthActionEnum;
import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.exception.RandomKeyCreateTimeoutException;
import com.appspot.mydoctor.model.auth.TwitterAuthSessionModel;
import com.appspot.mydoctor.model.base.AccountModel;
import com.appspot.mydoctor.util.DateUtil;
import com.appspot.mydoctor.util.PropertiesUtil;
import com.appspot.mydoctor.util.UniqueEntityUtil;

public class TwitterOAuth extends BaseAuth {

	private static Logger LOGGER = Logger.getLogger(TwitterOAuth.class);

	@Override
	public AccountModel getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthActionEnum auth(HttpServletRequest request, HttpServletResponse response, TerminalTypeEnum terminalType) {
		try {
			String consumerKey = PropertiesUtil.getOauthProperties().getProperty("consumer-key-tw");
			String consumerSecret = PropertiesUtil.getOauthProperties().getProperty("consumer-secret-tw");
			String ret = request.getParameter("ret");

			ConfigurationBuilder confbuilder = new ConfigurationBuilder();
			confbuilder.setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret);

			Twitter twitter = new TwitterFactory(confbuilder.build()).getInstance();

			String tempSessionId = UniqueEntityUtil.getSessionKey(TwitterAuthSessionModel.class.getSimpleName(), TwitterAuthSessionModel.SESSION_KEY_LENGTH);
			RequestToken requestToken = twitter.getOAuthRequestToken(getCallbackURL(request, tempSessionId));

			TwitterAuthSessionModel model = new TwitterAuthSessionModel();
			model.setTwitter(twitter);
			model.setRequestToken(requestToken);
			model.setTerminalType(terminalType);
			model.setExpireDate(DateUtil.getExpireDateMinutes(MydoctorConstant.getSessionExpireMinutes()));
			model.setSessionKey(tempSessionId);
			if (StringUtils.isNotEmpty(ret)) {
				model.setRedirectUrl(ret);
			}
			Datastore.put(model);

			setRedirectURL(requestToken.getAuthenticationURL());
			return AuthActionEnum.REDIRECT;

		} catch (TwitterException e) {
			LOGGER.fatal("twitter auth failed", e);
		} catch (RandomKeyCreateTimeoutException e) {
			LOGGER.fatal("generate session id failed", e);
		}
		return AuthActionEnum.FAILED;
	}

	private String getCallbackURL(HttpServletRequest request, String sessionId) {
		return request.getRequestURL().toString().replace(request.getRequestURI(), "") + "/callback/tw?tid=" + sessionId;
	}

}
