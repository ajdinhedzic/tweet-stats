package com.hedzic.ajdin.tweetstats.service;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import com.hedzic.ajdin.tweetstats.repository.TwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {

    @Autowired
    private TwitterRepository twitterRepository;

    public List<Tweet> findTweetsByTwitterHandle(String twitterHandle) {
        List<Status> statuses = twitterRepository.fetchTweetsBy(twitterHandle);
        List<Tweet> tweets = new ArrayList<>();
        for (Status status : statuses) {
            Tweet tweet = new Tweet();
            tweet.setText(status.getText());
            tweets.add(tweet);
        }
        return tweets;
    }
}
