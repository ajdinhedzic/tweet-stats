package com.hedzic.ajdin.tweetstats.controller;

import com.hedzic.ajdin.tweetstats.service.TwitterService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @Autowired
    private TwitterService twitterService;

    @RequestMapping("/")
    String home() {
        return "index.html";
    }

    @RequestMapping(value = "/{twitterHandle}/tweets", method = RequestMethod.GET)
    @ResponseBody
    String findTweetsByTwitterHandle(@PathVariable String twitterHandle) {
        return new JSONObject().put("tweets", twitterService.findTweetsByTwitterHandle(twitterHandle)).toString();
    }

    @RequestMapping(value = "/{twitterHandle}/sentiment", method = RequestMethod.GET)
    @ResponseBody
    String sentimentByTwitterHandle(@PathVariable String twitterHandle) {
        return twitterService.analyzeTweets(twitterHandle).toString();
    }
}