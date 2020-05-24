package com.androidmonk.gymtrainee.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidmonk.gymtrainee.R;
import com.androidmonk.gymtrainee.ui.WorkoutYoutubeActivity;
import com.androidmonk.gymtrainee.database.VideoEntity;
import com.androidmonk.gymtrainee.model.Video;
import com.androidmonk.gymtrainee.utils.AppConstants;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context context;
    private List<VideoEntity> list;

    public FavoriteAdapter(Context context, List<VideoEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.workout_list_video_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            Glide.with(context).load(list.get(position).getVideo_thumb()).into(holder.imageView);
        }catch (Exception e){
            Log.d(AppConstants.TAG_FAVORITE_VIDEO, context.getResources().getString(R.string.glide_error));
        }

        //load text
        holder.title_name.setText(list.get(position).getVideo_title());
        holder.fav_name.setText(context.getResources().getString(R.string.favorite_video));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WorkoutYoutubeActivity.class);
                //push event using EventBus
                EventBus.getDefault().postSticky(new Video(list.get(position).getVideo_id(),list.get(position).getVideo_title(),list.get(position).getVideo_des(),list.get(position).getVideo_thumb()));
                context.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.video_thumb_imageView)
        ImageView imageView;
        @BindView(R.id.video_title_text)
        TextView title_name;
        @BindView(R.id.channel_name_text)
        TextView fav_name;
        @BindView(R.id.video_layout)
        RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
