package com.appspot.mydoctor.auth;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;

public abstract class BaseAuth {

    protected static final Logger logger = Logger.getLogger(BaseAuth.class
        .getName());

    protected User user = null;

    public abstract User getUser();

    public abstract boolean auth(HttpServletRequest request,
            HttpServletResponse response);

}
