package com.hedzic.ajdin.tweetstats.repository;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("sentimentAnalysisRepository")
@Profile("dev")
public class FakeSentimentAnalysisRepository implements SentimentAnalysisRepository{

    @Override
    public JSONArray analyzeAllTweets(List<Tweet> tweets) {
        String json = "[[{\"category_id\":1679199,\"probability\":0.915,\"label\":\"negative\"}]," +
                "[{\"category_id\":1679200,\"probability\":1.0,\"label\":\"neutral\"}]," +
                "[{\"category_id\":1679200,\"probability\":1.0,\"label\":\"neutral\"}]," +
                "[{\"category_id\":1679200,\"probability\":1.0,\"label\":\"neutral\"}]," +
                "[{\"category_id\":1679200,\"probability\":0.93,\"label\":\"neutral\"}]," +
                "[{\"category_id\":1679199,\"probability\":1.0,\"label\":\"negative\"}]," +
                "[{\"category_id\":1679198,\"probability\":0.723,\"label\":\"positive\"}]]";
        JSONArray array = null;
        try {
            array = (JSONArray) new JSONParser().parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return array;
    }

}
