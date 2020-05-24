package com.androidmonk.gymtrainee.model;

import com.google.gson.annotations.SerializedName;

public class ResourceId {
    @SerializedName("videoId")
    private String video_id;

    public ResourceId(String video_id) {
        this.video_id = video_id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }
}
