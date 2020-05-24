package com.androidmonk.gymtrainee.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidmonk.gymtrainee.R;
import com.androidmonk.gymtrainee.ui.WorkoutListActivity;
import com.androidmonk.gymtrainee.model.WorkoutList;
import com.androidmonk.gymtrainee.utils.AppConstants;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutListAdapter.ViewHolder> {

    private Context context;
    private List<WorkoutList> list;
    public WorkoutListAdapter(Context context,List<WorkoutList> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.workout_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //load image
        Glide.with(context).load(list.get(position).getImage_id()).into(holder.workout_img);
        //workout name
        holder.workout_name.setText(list.get(position).getWorkout_name());

        //onClick
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WorkoutListActivity.class);
                i.putExtra(AppConstants.INTENT_WORKOUT_NAME_KEY,list.get(position).getWorkout_name());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.workout_name_text)
        TextView workout_name;
        @BindView(R.id.workout_image)
        ImageView workout_img;
        @BindView(R.id.workout_item_relative_layout)
        RelativeLayout relativeLayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
