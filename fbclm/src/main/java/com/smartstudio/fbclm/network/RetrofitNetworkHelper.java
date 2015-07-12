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
 * Created by juanyanezgc on 10/05/15.
 */
@PerApplication
public class RetrofitNetworkHelper implements NetworkHelper {
    private interface RestApi {
        @GET("/leagues")
        List<League> leagues(@Query("season") int seasonId);

        @Headers("Cache-Control: max-stale=" + Integer.MAX_VALUE)
        @GET("/leagues")
        List<League> cachedLeagues(@Query("season") int seasonId);
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
