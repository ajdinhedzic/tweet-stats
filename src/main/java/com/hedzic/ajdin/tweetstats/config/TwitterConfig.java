package com.hedzic.ajdin.tweetstats.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterConfig {

    @Autowired
    TwitterFactoryWrapper twitterFactoryWrapper;

    @Value("${twitter.consumer.key}")
    String consumerKey;

    @Value("${twitter.consumer.secret}")
    String consumerSecret;

    @Value("${twitter.access.token}")
    String accessToken;

    @Value("${twitter.access.secret}")
    String accessSecret;

    public Twitter getTwitter() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumerKey);
        builder.setOAuthConsumerSecret(consumerSecret);
        builder.setOAuthAccessToken(accessToken);
        builder.setOAuthAccessTokenSecret(accessSecret);
        return twitterFactoryWrapper.buildTwitter(builder);
    }
}
