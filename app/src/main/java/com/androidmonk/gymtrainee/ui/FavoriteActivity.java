package com.androidmonk.gymtrainee.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.androidmonk.gymtrainee.component.DaggerUniversalComponents;
import com.androidmonk.gymtrainee.Module.UniversalDaggerModule;
import com.androidmonk.gymtrainee.R;
import com.androidmonk.gymtrainee.adapter.FavoriteAdapter;
import com.androidmonk.gymtrainee.component.UniversalComponents;
import com.androidmonk.gymtrainee.database.MyRoomDatabase;
import com.androidmonk.gymtrainee.database.VideoEntity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteActivity extends AppCompatActivity {

    @BindView(R.id.favorite_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.adView_banner)
    AdView adView;

    @Inject
    LinearLayoutManager linearLayoutManager;

    private UniversalComponents components;
    private MyRoomDatabase db;
    private List<VideoEntity> videoEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ButterKnife.bind(this);
        components = DaggerUniversalComponents.builder()
                .universalDaggerModule(new UniversalDaggerModule(FavoriteActivity.this))
                .build();

        components.inject(FavoriteActivity.this);
        getSupportActionBar().setTitle("Favorite Videos");
        db = MyRoomDatabase.getInstance(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    @Override
    protected void onStart() {
        super.onStart();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                videoEntityList =db.videoDao().getFavoriteVideoList();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(new FavoriteAdapter(FavoriteActivity.this, videoEntityList));
                    }
                });
            }
        });
    }
}
