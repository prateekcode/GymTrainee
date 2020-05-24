package com.androidmonk.gymtrainee.api;

import com.androidmonk.gymtrainee.model.VideoResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApiInterface {

    @GET("search")
    Observable<VideoResult> getSearchVideos(@Query("key") String apiKey,
                                            @Query("part") String videoPart,
                                            @Query("q") String query,
                                            @Query("type") String type,
                                            @Query("maxResults") int maxResults
    );

}
