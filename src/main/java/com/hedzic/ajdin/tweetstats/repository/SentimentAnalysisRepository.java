package com.hedzic.ajdin.tweetstats.repository;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class SentimentAnalysisRepository {

    @Value("${monkey.learn.token}")
    private String token;

    @Value("${monkey.learn.module}")
    private String module;

    public JSONArray analyzeAllTweets(List<Tweet> tweets){
        MonkeyLearn monkeyLearn = new MonkeyLearn(token);
        MonkeyLearnResponse classify;
        try {
            classify = monkeyLearn.classifiers.classify(module, extractTextFromTweets(tweets));
        } catch (MonkeyLearnException e) {
            return new JSONArray();
        }
        return classify.arrayResult;
    }

    protected String[] extractTextFromTweets(List<Tweet> tweets){
        Stream<String> tweetStream = tweets.stream()
                .map(Tweet::getText);
        return tweetStream.toArray(size -> new String[size]);
    }

}