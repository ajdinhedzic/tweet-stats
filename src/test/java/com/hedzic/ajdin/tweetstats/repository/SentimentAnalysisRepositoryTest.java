package com.hedzic.ajdin.tweetstats.repository;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SentimentAnalysisRepositoryTest {

    @Test
    public void extractTextFromTweetsReturnsArray() throws Exception {
        SentimentAnalysisRepository sentimentAnalysisRepository = new SentimentAnalysisRepository();
        Tweet tweet = new Tweet();
        tweet.setText("this is a tweet");
        String[] tweets = sentimentAnalysisRepository.extractTextFromTweets(Collections.singletonList(tweet));
        assertEquals(1, tweets.length);
        assertEquals(tweet.getText(), tweets[0]);
    }

    @Test
    public void extractTextFromTweetsReturnsArrayOfTextFromTweets() throws Exception {
        SentimentAnalysisRepository sentimentAnalysisRepository = new SentimentAnalysisRepository();
        Tweet tweet = new Tweet();
        tweet.setText("this is a tweet");
        Tweet otherTweet = new Tweet();
        otherTweet.setText("second tweet");
        String[] tweets = sentimentAnalysisRepository.extractTextFromTweets(Arrays.asList(tweet, otherTweet));
        assertEquals(tweet.getText(), tweets[0]);
        assertEquals(otherTweet.getText(), tweets[1]);
    }

}