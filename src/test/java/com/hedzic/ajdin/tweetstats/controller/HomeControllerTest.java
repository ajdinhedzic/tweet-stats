package com.hedzic.ajdin.tweetstats.controller;

import com.hedzic.ajdin.tweetstats.domain.Tweet;
import com.hedzic.ajdin.tweetstats.service.TwitterService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Mock
    private TwitterService twitterService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        when(twitterService.findTweetsByTwitterHandle(anyString())).thenReturn(new ArrayList<Tweet>());
    }

    @Test
    public void initialMappingReturns200() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void tweetsByTwitterHandleReturns200() throws Exception {
        String username = "ajdinhedzic";
        mockMvc.perform(get("/" + username + "/tweets"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void tweetsByTwitterhandleCallsTwitterRepositoryWithTwitterhandle() throws Exception {
        homeController.findTweetsByTwitterHandle("ajdinhedzic");
        verify(twitterService).findTweetsByTwitterHandle("ajdinhedzic");
    }

    @Test
    public void tweetsByTwitterhandleReturnsRepositoryResult() throws Exception {
        Tweet tweet = new Tweet();
        tweet.setText("this is a tweet");
        when(twitterService.findTweetsByTwitterHandle(anyString())).thenReturn(Collections.singletonList(tweet));
        String response = homeController.findTweetsByTwitterHandle("ajdinhedzic");
        JSONObject jsonObject = new JSONObject(response);
        assertEquals(tweet.getText(), jsonObject.getJSONArray("tweets").getJSONObject(0).getString("text"));
    }
}