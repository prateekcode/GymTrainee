package com.androidmonk.gymtrainee.model;

import com.google.gson.annotations.SerializedName;

public class Snippet {
    @SerializedName("channelId")
    private String channelId;
    @SerializedName("channelTitle")
    private String channel_title;
    @SerializedName("title")
    private String title;
    @SerializedName("thumbnails")
    private Thumbnails thumbnails;
    @SerializedName("description")
    private String description;

    public Snippet(String channelId, String channel_title, String title, Thumbnails thumbnails,String description) {
        this.channelId = channelId;
        this.channel_title = channel_title;
        this.title = title;
        this.thumbnails = thumbnails;
        this.description = description;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannel_title() {
        return channel_title;
    }

    public void setChannel_title(String channel_title) {
        this.channel_title = channel_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
