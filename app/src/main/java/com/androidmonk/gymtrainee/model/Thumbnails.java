package com.androidmonk.gymtrainee.model;

import com.google.gson.annotations.SerializedName;

public class Thumbnails {

    @SerializedName("medium")
    private Thumbnail_medium thumbnail_medium;
    @SerializedName("maxres")
    private Thumbnail_high thumbnail_high;

    public Thumbnails(Thumbnail_medium thumbnail_medium,Thumbnail_high thumbnail_high) {
        this.thumbnail_medium = thumbnail_medium;
        this.thumbnail_high = thumbnail_high;
    }

    public Thumbnail_medium getThumbnail_medium() {
        return thumbnail_medium;
    }

    public void setThumbnail_medium(Thumbnail_medium thumbnail_medium) {
        this.thumbnail_medium = thumbnail_medium;
    }

    public Thumbnail_high getThumbnail_high() {
        return thumbnail_high;
    }

    public void setThumbnail_high(Thumbnail_high thumbnail_high) {
        this.thumbnail_high = thumbnail_high;
    }
}
