package com.hedzic.ajdin.tweetstats.repository;

import java.util.List;

public interface TwitterRepository {

    List fetchTweetsBy(String twitterHandle);

}