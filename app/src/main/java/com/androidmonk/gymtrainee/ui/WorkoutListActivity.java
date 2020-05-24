package com.androidmonk.gymtrainee.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidmonk.gymtrainee.adapter.VideoAdapter;
import com.androidmonk.gymtrainee.component.DaggerUniversalComponents;
import com.androidmonk.gymtrainee.Module.UniversalDaggerModule;
import com.androidmonk.gymtrainee.R;
import com.androidmonk.gymtrainee.api.YoutubeApiInterface;
import com.androidmonk.gymtrainee.component.UniversalComponents;
import com.androidmonk.gymtrainee.model.VideoItem;
import com.androidmonk.gymtrainee.model.VideoResult;
import com.androidmonk.gymtrainee.utils.AppConstants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class WorkoutListActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    @Inject
    YoutubeApiInterface youtubeApiInterface;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.progress_Bar)
    ProgressBar progressBar;
    @BindView(R.id.video_list_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.adView_banner)
    AdView adView;

    private String workout_name = "";
    private UniversalComponents components;
    private Observable<VideoResult> videoResultObservable;
    private List<VideoItem> videoItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        ButterKnife.bind(this);
        components = DaggerUniversalComponents.builder()
                .universalDaggerModule(new UniversalDaggerModule(WorkoutListActivity.this))
                .build();

        components.inject(WorkoutListActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //titleActionBar
        workoutTitle();
        videoResults();
    }

    private void videoResults() {
        videoResultObservable = youtubeApiInterface.getSearchVideos(getResources().getString(R.string.api_key),"snippet",workout_name+"for men at home","video",49);
        videoResultObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onNext(VideoResult value) {
                        videoItemList = value.getVideoItemList();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(WorkoutListActivity.this,getResources().getString(R.string.internet_error),Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onComplete() {
                        progressBar.setVisibility(View.GONE);
                        if(videoItemList!=null)recyclerView.setAdapter(new VideoAdapter(WorkoutListActivity.this,videoItemList));
                    }
                });

    }

    private void workoutTitle() {
        Intent intent = getIntent();
        if (intent.hasExtra(AppConstants.INTENT_WORKOUT_NAME_KEY)){
            workout_name = intent.getStringExtra(AppConstants.INTENT_WORKOUT_NAME_KEY);
            getSupportActionBar().setTitle(workout_name);
        }
    }
}
