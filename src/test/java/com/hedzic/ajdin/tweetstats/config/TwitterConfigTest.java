package com.hedzic.ajdin.tweetstats.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterConfigTest {

    @InjectMocks
    TwitterConfig twitterConfig;

    @Mock
    TwitterFactoryWrapper twitterFactoryWrapper;

    @Before
    public void setUp() throws Exception {
        when(twitterFactoryWrapper.buildTwitter(any(ConfigurationBuilder.class))).thenCallRealMethod();
    }

    @Test
    public void twitterFactoryWrapperCalledWithConfigurationBuilder(){
        twitterConfig.getTwitter();
        verify(twitterFactoryWrapper).buildTwitter(any(ConfigurationBuilder.class));
    }

    @Test
    public void oAuthConsumerKeyIsSetOnTwitter(){
        ReflectionTestUtils.setField(twitterConfig, "consumerKey", "abc");
        Twitter twitter = twitterConfig.getTwitter();
        assertEquals("abc", twitter.getConfiguration().getOAuthConsumerKey());
    }
    
    @Test
    public void oAuthConsumerSecretIsSetOnTwitter(){
        ReflectionTestUtils.setField(twitterConfig, "consumerSecret", "def");
        Twitter twitter = twitterConfig.getTwitter();
        assertEquals("def", twitter.getConfiguration().getOAuthConsumerSecret());
    }

    @Test
    public void oAuthAccessTokenIsSetOnTwitter(){
        ReflectionTestUtils.setField(twitterConfig, "accessToken", "xyz");
        Twitter twitter = twitterConfig.getTwitter();
        assertEquals("xyz", twitter.getConfiguration().getOAuthAccessToken());
    }

    @Test
    public void oAuthAccessTokenSecretIsSetOnTwitter(){
        ReflectionTestUtils.setField(twitterConfig, "accessSecret", "any");
        Twitter twitter = twitterConfig.getTwitter();
        assertEquals("any", twitter.getConfiguration().getOAuthAccessTokenSecret());
    }
}