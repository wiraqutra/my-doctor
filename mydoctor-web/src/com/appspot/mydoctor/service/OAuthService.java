package com.appspot.mydoctor.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthServiceProvider;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient4.HttpClient4;
import net.oauth.http.HttpClient;


public class OAuthService {

    private Properties prop;
    private File propFile;

    private String requestToken;
    private String tokenSecret;
    
    public OAuthService(String propertyFileName) throws FileNotFoundException, IOException {
        prop = new Properties();
        propFile = new File(propertyFileName);
        prop.load(new FileInputStream(propFile));
    }
    
    public OAuthAccessor createOAuthAccessor(String callbackURL, String requestTokenURL, String authorizeTokenURL, String accessTokenURL){
        String consumerKey = prop.getProperty("consumer-key");
        String consumerSecret = prop.getProperty("consumer-secret");
        
        OAuthServiceProvider provider = new OAuthServiceProvider(requestTokenURL, authorizeTokenURL, accessTokenURL);
        OAuthConsumer consumer = new OAuthConsumer(callbackURL, consumerKey, consumerSecret, provider);
        return new OAuthAccessor(consumer);
    }
    
    public void request(String callbackURL, String requestTokenURL, String authorizeTokenURL, String accessTokenURL) throws IOException, OAuthException, URISyntaxException{
        OAuthAccessor accessor = createOAuthAccessor(callbackURL, requestTokenURL, authorizeTokenURL, accessTokenURL);
        OAuthClient client = new OAuthClient(new HttpClient4());
        client.getRequestToken(accessor);
        this.requestToken = accessor.requestToken;
        this.tokenSecret = accessor.tokenSecret;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }


}
