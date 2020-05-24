package com.androidmonk.gymtrainee.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VideoDao {

    @Query("SELECT * FROM videoEntity")
    List<VideoEntity> getFavoriteVideoList();
    @Query("SELECT * FROM videoEntity WHERE videoId LIKE :video_id")
    VideoEntity isVideoSaved(String video_id);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVideo(VideoEntity video);
    @Query("DELETE FROM videoEntity WHERE videoId LIKE :video_id")
    void deleteVideo(String video_id);




}
