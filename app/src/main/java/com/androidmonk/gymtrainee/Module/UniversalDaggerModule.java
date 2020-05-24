package com.androidmonk.gymtrainee.Module;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.androidmonk.gymtrainee.api.YoutubeApiInterface;
import com.androidmonk.gymtrainee.utils.AppConstants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class UniversalDaggerModule {

    private Context context;
    public UniversalDaggerModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl(AppConstants.YOUTUBE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public YoutubeApiInterface youtubeApiInterface(Retrofit retrofit){
        return retrofit.create(YoutubeApiInterface.class);
    }

    @Provides
    @Singleton
    public LinearLayoutManager linearLayoutManager(){
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }

}
