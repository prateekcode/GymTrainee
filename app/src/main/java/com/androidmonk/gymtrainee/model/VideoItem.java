package com.androidmonk.gymtrainee.model;

import com.google.gson.annotations.SerializedName;

public class VideoItem {

    @SerializedName("kind")
    private String video_kind;
    @SerializedName("snippet")
    private Snippet snippet;
    @SerializedName("id")
    private ResourceId resourceId;

    public VideoItem(String video_kind,ResourceId resourceId,Snippet snippet) {
        this.video_kind = video_kind;
        this.resourceId = resourceId;
        this.snippet = snippet;
    }

    public String getVideo_kind() {
        return video_kind;
    }

    public void setVideo_kind(String video_kind) {
        this.video_kind = video_kind;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public ResourceId getResourceId() {
        return resourceId;
    }

    public void setResourceId(ResourceId resourceId) {
        this.resourceId = resourceId;
    }
}
