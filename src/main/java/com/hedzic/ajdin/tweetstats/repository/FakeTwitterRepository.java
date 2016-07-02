package com.hedzic.ajdin.tweetstats.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import twitter4j.Status;

import java.util.Collections;
import java.util.List;

@Repository("twitterRepository")
@Profile("dev")
public class FakeTwitterRepository implements TwitterRepository {
    @Override
    public List<Status> fetchTweetsBy(String twitterHandle) {
        return Collections.EMPTY_LIST;
    }
}