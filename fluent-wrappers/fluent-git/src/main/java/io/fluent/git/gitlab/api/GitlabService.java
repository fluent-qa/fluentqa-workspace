package io.fluent.git.gitlab.api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitlabService {

  @GET("api/v4/users")
  Call<List<GitlabMember>> getUser(@Query("username") String username);

  @GET("api/v4/users/{id}/memberships")
  Call<List<GitlabMembership>> getUserMembers(@Path("id") final Long id);
}
