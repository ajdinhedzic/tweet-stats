package com.hedzic.ajdin.tweetstats.repository;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import org.json.simple.JSONArray;

import java.util.List;

public interface SentimentAnalysisRepository {

    JSONArray analyzeAllTweets(List<Tweet> tweets);
}