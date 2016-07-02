package com.hedzic.ajdin.tweetstats.repository;

import com.hedzic.ajdin.tweetstats.config.TwitterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.Collections;
import java.util.List;

@Repository("twitterRepository")
@Profile("production")
public class TwitterRepositoryImpl implements TwitterRepository {

    @Autowired
    private TwitterConfig twitterConfig;

    public List<Status> fetchTweetsBy(String twitterHandle) {
        Twitter twitter = twitterConfig.getTwitter();
        try {
            return twitter.getUserTimeline(twitterHandle);
        } catch (TwitterException e) {
            return Collections.EMPTY_LIST;
        }
    }
}