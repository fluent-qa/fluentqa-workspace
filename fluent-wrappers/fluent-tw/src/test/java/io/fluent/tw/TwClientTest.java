package io.fluent.tw;

import io.fluent.tw.service.FollowingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwClientTest {

    @Test
    public void testGetTWClient(){
        TwClient twClient = new TwClient();
        assertNotNull(twClient.getApiInstance());
    }

    @Test
    public void testGetUserFollowings(){
        TwClient twClient = new TwClient();
        String userId= "simonte31544649";
        FollowingService service = new FollowingService(twClient.getApiInstance());
        var result = service.getFollowingList(userId,150,"",3);
        System.out.println(result);
    }
}