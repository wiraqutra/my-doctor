package com.appspot.mydoctor.auth;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.slim3.datastore.Datastore;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import com.appspot.mydoctor.enumeration.TerminalTypeEnum;
import com.appspot.mydoctor.model.TwitterAuthSessionModel;
import com.appspot.mydoctor.model.base.AccountModel;
import com.appspot.mydoctor.util.PropertiesUtil;
import com.google.appengine.api.datastore.Key;

public class TwitterOAuth extends BaseAuth {

	private static Logger LOGGER = Logger.getLogger(TwitterOAuth.class);

	@Override
	public AccountModel getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean auth(HttpServletRequest request, HttpServletResponse response, TerminalTypeEnum terminalType) {
		try {
			String consumerKey = PropertiesUtil.getOauthProperties().getProperty("consumer-key-tw");
			String consumerSecret = PropertiesUtil.getOauthProperties().getProperty("consumer-secret-tw");
			System.out.println(consumerKey);
			System.out.println(consumerSecret);
			Key key = Datastore.allocateId(TwitterAuthSessionModel.class);
			ConfigurationBuilder confbuilder = new ConfigurationBuilder();
			confbuilder.setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret);

			Twitter twitter = new TwitterFactory(confbuilder.build()).getInstance();
			RequestToken requestToken = twitter.getOAuthRequestToken(getCallbackURL(request, key));

			TwitterAuthSessionModel model = new TwitterAuthSessionModel();
			model.setKey(key);
			model.setTwitter(twitter);
			model.setRequestToken(requestToken);
			model.setTerminalType(terminalType);
			Calendar cal = Calendar.getInstance(Locale.JAPAN);
			cal.add(Calendar.MINUTE, 30);
			model.setExpireDate(new Date(cal.getTimeInMillis()));
			Datastore.put(model);

			response.sendRedirect(requestToken.getAuthenticationURL());

		} catch (TwitterException e) {
			LOGGER.fatal("twitter auth failed", e);
		} catch (IOException e) {
			LOGGER.fatal("twitter auth failed", e);
		}
		return false;
	}

	private String getCallbackURL(HttpServletRequest request, Key key) {
		return request.getRequestURL().toString().replace(request.getRequestURI(), "") + "/pc/callback/tw?key=" + Datastore.keyToString(key);
	}

}
