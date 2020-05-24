package com.androidmonk.gymtrainee.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoResult {

    @SerializedName("items")
    private List<VideoItem> videoItemList;

    public VideoResult(List<VideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }

    public List<VideoItem> getVideoItemList() {
        return videoItemList;
    }

    public void setVideoItemList(List<VideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }
}
