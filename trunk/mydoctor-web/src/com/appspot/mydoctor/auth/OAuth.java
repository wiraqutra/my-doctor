package com.appspot.mydoctor.auth;

public abstract class OAuth extends BaseAuth{

    public abstract String getRequestToken();
    
    public abstract String getAuthToken();
    
    public abstract String getAccessToken();
}
