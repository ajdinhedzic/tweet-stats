package com.hedzic.ajdin.tweetstats.service;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import com.hedzic.ajdin.tweetstats.doubles.StatusDouble;
import com.hedzic.ajdin.tweetstats.repository.TwitterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.Status;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceTest {

    @InjectMocks
    TwitterService twitterService;

    @Mock
    TwitterRepository twitterRepository;

    @Test
    public void findTweetsByTwitterHandleCallsTwitterRepositoryFindTweetsBy() throws Exception {
        twitterService.findTweetsByTwitterHandle("twitter handle");
        verify(twitterRepository).fetchTweetsBy("twitter handle");
    }

    @Test
    public void findTweetsByTwitterHandleTransformsStatusToTweet() throws Exception {
        String tweet = "this is a tweet";
        StatusDouble status = new StatusDouble();
        status.setText(tweet);
        when(twitterRepository.fetchTweetsBy(anyString())).thenReturn(Collections.<Status>singletonList(status));
        List<Tweet> tweets = twitterService.findTweetsByTwitterHandle("twitter handle");
        assertEquals(tweet, tweets.get(0).getText());
    }

}