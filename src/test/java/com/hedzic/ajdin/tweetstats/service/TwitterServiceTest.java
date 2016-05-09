package com.hedzic.ajdin.tweetstats.service;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import com.hedzic.ajdin.tweetstats.doubles.StatusDouble;
import com.hedzic.ajdin.tweetstats.repository.SentimentAnalysisRepository;
import com.hedzic.ajdin.tweetstats.repository.TwitterRepository;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.Status;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceTest {

    @InjectMocks
    TwitterService twitterService;

    @Mock
    TwitterRepository twitterRepository;

    @Mock
    SentimentAnalysisRepository analysisRepository;

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

    @Test
    public void analyzeTweetsCallsTwitterRepositoryFetchTweetsByWithUsername() throws Exception {
        twitterService.analyzeTweets("twitter handle");
        verify(twitterRepository).fetchTweetsBy("twitter handle");
    }
    
    @Test
    public void analyzeTweetsCallsSentimentAnalysisRepository() throws Exception {
        String text = "this is a tweet";
        StatusDouble status = new StatusDouble();
        status.setText(text);
        when(twitterRepository.fetchTweetsBy(any())).thenReturn(Collections.<Status>singletonList(status));
        Tweet tweet = new Tweet();
        tweet.setText(text);
        twitterService.analyzeTweets(null);
        verify(analysisRepository).analyzeAllTweets(Collections.singletonList(tweet));
    }

    @Test
    public void analyzeTweetsReturnsCountOfPositiveTweets() throws Exception {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("[{\"category_id\":329048,\"probability\":1.0,\"label\":\"positive\"}]");
        when(analysisRepository.analyzeAllTweets(any())).thenReturn(jsonArray);
        JSONObject result = twitterService.analyzeTweets(null);
        assertEquals(1, result.get("positive"));
    }

    @Test
    public void analyzeTweetsReturnsCountOfNeutralTweets() throws Exception {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("[{\"category_id\":329048,\"probability\":.5,\"label\":\"neutral\"}]");
        when(analysisRepository.analyzeAllTweets(any())).thenReturn(jsonArray);
        JSONObject result = twitterService.analyzeTweets(null);
        assertEquals(1, result.get("neutral"));
    }
}