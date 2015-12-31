package com.smartstudio.fbclm.network;

import com.smartstudio.fbclm.injection.scopes.PerApplication;
import com.smartstudio.fbclm.model.League;

import java.util.List;

import javax.inject.Inject;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * {@link NetworkHelper} implementation using Retrofit library
 */
@PerApplication
public class RetrofitNetworkHelper implements NetworkHelper {
    private static final String CACHE_HEADER = "Cache-Control:  only-if-cached, max-stale="
            + Integer.MAX_VALUE;
    private static final String LEAGUES_ENDPOINT = "/leagues";
    private static final String SEASON_PARAM = "season";


    private interface RestApi {
        @GET(LEAGUES_ENDPOINT)
        List<League> leagues(@Query(SEASON_PARAM) int seasonId);

        @Headers(CACHE_HEADER)
        @GET(LEAGUES_ENDPOINT)
        List<League> cachedLeagues(@Query(SEASON_PARAM) int seasonId);
    }

    private RestApi mRestApi;

    @Inject
    public RetrofitNetworkHelper(RestAdapter.Builder restBuilder) {
        mRestApi = restBuilder
                .build().create(RestApi.class);
    }

    @Override
    public List<League> requestLeagues(int seasonId, boolean forceCache) {
        return forceCache ? mRestApi.cachedLeagues(seasonId) : mRestApi.leagues(seasonId);
    }
}
