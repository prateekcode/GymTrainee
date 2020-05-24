package com.androidmonk.gymtrainee.model;

public class Video {
    private String video_id;
    private String video_title;
    private String video_des;
    private String video_thumb;

    public Video() {}

    public Video(String video_id, String video_title, String video_des, String video_thumb) {
        this.video_id = video_id;
        this.video_title = video_title;
        this.video_des = video_des;
        this.video_thumb = video_thumb;
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
