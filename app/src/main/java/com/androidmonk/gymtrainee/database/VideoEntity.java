package com.androidmonk.gymtrainee.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class VideoEntity {


    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "videoId")
    private String video_id;
    @ColumnInfo(name = "videoTitle")
    private String video_title;
    @ColumnInfo(name = "videoDes")
    private String video_des;
    @ColumnInfo(name = "videoThumb")
    private String video_thumb;

    @Ignore
    public VideoEntity(){}

    public VideoEntity(int uid, String video_id, String video_title, String video_des, String video_thumb) {
        this.uid = uid;
        this.video_id = video_id;
        this.video_title = video_title;
        this.video_des = video_des;
        this.video_thumb = video_thumb;
    }

    @Ignore
    public VideoEntity(String video_id, String video_title, String video_des, String video_thumb) {
        this.video_id = video_id;
        this.video_title = video_title;
        this.video_des = video_des;
        this.video_thumb = video_thumb;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_des() {
        return video_des;
    }

    public void setVideo_des(String video_des) {
        this.video_des = video_des;
    }

    public String getVideo_thumb() {
        return video_thumb;
    }

    public void setVideo_thumb(String video_thumb) {
        this.video_thumb = video_thumb;
    }
}
