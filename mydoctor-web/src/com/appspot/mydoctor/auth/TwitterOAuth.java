package com.appspot.mydoctor.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;

public class TwitterOAuth extends BaseAuth {

    @Override
    public User getUser() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean auth(HttpServletRequest request, HttpServletResponse response) {

        return false;
    }

}
