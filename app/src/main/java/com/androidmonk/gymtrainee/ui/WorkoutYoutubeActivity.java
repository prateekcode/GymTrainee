package com.androidmonk.gymtrainee.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidmonk.gymtrainee.R;
import com.androidmonk.gymtrainee.data.WorkoutTipsContainer;
import com.androidmonk.gymtrainee.database.MyRoomDatabase;
import com.androidmonk.gymtrainee.database.VideoEntity;
import com.androidmonk.gymtrainee.model.Video;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkoutYoutubeActivity extends AppCompatActivity {

    private String video_id;
    private String video_des;
    private String video_thumb;
    private String video_title;
    private VideoEntity videoEntity;
    private MyRoomDatabase db;

    @BindView(R.id.youtube_player)
    YouTubePlayerView youTubePlayerView;
    @BindView(R.id.workout_done_btn)
    Button done_btn;
    @BindView(R.id.saveVideo_btn)
    Button save_btn;
    @BindView(R.id.workout_tips_text)
    TextView textView_tips;
    @BindView(R.id.video_descriptionText)
    TextView textView_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_youtube);

        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        db = MyRoomDatabase.getInstance(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView_des.setText(video_des);
        textView_tips.setText(new WorkoutTipsContainer().getTip());

        accessDatabase();
        youtubePlayerView();
        doneButton();
        saveButton();
    }

    private void saveButton() {
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        videoEntity = db.videoDao().isVideoSaved(video_id);
                        if (videoEntity == null){
                            db.videoDao().insertVideo(new VideoEntity(video_id, video_title, video_des, video_thumb));
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    save_btn.setBackgroundColor(getResources().getColor(R.color.colorExtra));
                                    save_btn.setText(getResources().getString(R.string.saved));
                                }
                            });
                        }else {
                            db.videoDao().deleteVideo(video_id);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    save_btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                                    save_btn.setText(getResources().getString(R.string.save));
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    private void accessDatabase() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                videoEntity = db.videoDao().isVideoSaved(video_id);
                if (videoEntity != null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            save_btn.setBackgroundColor(getResources().getColor(R.color.colorExtra));
                            save_btn.setText(getResources().getString(R.string.saved));
                        }
                    });
                }
            }
        });
    }

    private void youtubePlayerView(){
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(video_id, 0);
            }
        });
    }

    private void doneButton(){
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (youTubePlayerView != null){
                    youTubePlayerView.release();
                }
                onBackPressed();
            }
        });
    }



    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventBusVideoData(Video container){
        //get data and init
        video_id = container.getVideo_id();
        video_des = container.getVideo_des();
        video_title = container.getVideo_title();
        video_thumb = container.getVideo_thumb();
        //remove sticky
        EventBus.getDefault().removeStickyEvent(Video.class);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (youTubePlayerView!=null){
            youTubePlayerView.release();
        }
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
