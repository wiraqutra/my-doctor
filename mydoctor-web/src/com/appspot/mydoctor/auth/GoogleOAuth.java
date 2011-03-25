package com.appspot.mydoctor.auth;

import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.oauth.OAuthService;
import com.google.appengine.api.oauth.OAuthServiceFactory;
import com.google.appengine.api.users.User;

public class GoogleOAuth extends BaseAuth {

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public boolean auth(HttpServletRequest request, HttpServletResponse response) {
        try {
            OAuthService oauth = OAuthServiceFactory.getOAuthService();
            user = oauth.getCurrentUser();
            if (user != null && StringUtils.isNotBlank(user.getEmail())) {
                return true;
            }
        } catch (OAuthRequestException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        return false;
    }

}
