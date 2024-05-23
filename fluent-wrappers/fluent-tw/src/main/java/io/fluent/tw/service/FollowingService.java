package io.fluent.tw.service;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.UsersFollowingLookupResponse;

public class FollowingService {

  private TwitterApi client;

  public FollowingService(final TwitterApi client) {
    this.client = client;
  }

  /**
   * ENDPOINT: https://api.twitter.com/2/users/:id/following URL:
   * https://developer.twitter.com/en/docs/twitter-api/users/follows/api-reference/get-users-id-following#tab0
   *
   * @return
   */
  public UsersFollowingLookupResponse getFollowingList(
      String userId, int maxResult, String pagination_token, int retries) {
    try {
      var result = this.client.users().usersIdFollowing(userId, maxResult, pagination_token);
      return result;
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }

  //    public void getListMembers(){
  //        this.client.lists().getUserListMemberships();
  //    }
}
