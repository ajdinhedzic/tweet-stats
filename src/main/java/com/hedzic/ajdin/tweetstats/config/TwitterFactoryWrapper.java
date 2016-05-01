package com.hedzic.ajdin.tweetstats.config;

import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterFactoryWrapper {

    public Twitter buildTwitter(ConfigurationBuilder configurationBuilder){
        return new TwitterFactory(configurationBuilder.build()).getInstance();
    }
}
