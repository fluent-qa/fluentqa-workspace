package io.fluent.tw;
import com.twitter.clientlib.TwitterCredentialsBearer;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import io.fluent.builtin.config.DotEnvConfig;

/**
 * Twitter Client For Get Following
 */
public class TwClient {
    private static final String TW_BEAR_TOKEN="TW_BEAR_TOKEN";

    public TwitterApi getApiInstance(){
        String bearToken = DotEnvConfig.getValue(TW_BEAR_TOKEN);
        TwitterApi apiInstance = new TwitterApi();
//        TwitterCredentialsOAuth2 oAuth2 = new TwitterCredentialsOAuth2()
        // Instantiate auth credentials (App-only example)
        TwitterCredentialsBearer credentials = new TwitterCredentialsBearer(bearToken);
        // Pass credentials to library client
        apiInstance.setTwitterCredentials(credentials);
        return apiInstance;
    }

}
