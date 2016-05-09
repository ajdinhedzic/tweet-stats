package com.hedzic.ajdin.tweetstats.service;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import com.hedzic.ajdin.tweetstats.repository.SentimentAnalysisRepository;
import com.hedzic.ajdin.tweetstats.repository.TwitterRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    @Autowired
    private TwitterRepository twitterRepository;

    @Autowired
    private SentimentAnalysisRepository analysisRepository;

    public List<Tweet> findTweetsByTwitterHandle(String twitterHandle) {
        List<Status> statuses = twitterRepository.fetchTweetsBy(twitterHandle);
        return transformStatusToTweet(statuses);
    }

    private List<Tweet> transformStatusToTweet(List<Status> statuses) {
        return statuses.stream()
                .map(status -> {
                    Tweet tweet = new Tweet();
                    tweet.setText(status.getText());
                    return tweet;
                })
                .collect(Collectors.toList());
    }

    public JSONObject analyzeTweets(String twitterHandle) {
        List<Status> statusList = twitterRepository.fetchTweetsBy(twitterHandle);
        JSONArray response = new JSONArray(analysisRepository.analyzeAllTweets(transformStatusToTweet(statusList)));
        Map<String, Integer> sentimentCount = createHashMap();
        response.forEach(element -> {
            String sentiment = new JSONArray(element.toString()).getJSONObject(0).get("label").toString();
            sentimentCount.put(sentiment, sentimentCount.get(sentiment) + 1);
        });
        return new JSONObject(sentimentCount);
    }

    private Map<String, Integer> createHashMap() {
        HashMap<String, Integer> resultMap = new HashMap<>();
        resultMap.put("negative", 0);
        resultMap.put("neutral", 0);
        resultMap.put("positive", 0);
        return resultMap;
    }
}
