package com.androidmonk.gymtrainee.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.androidmonk.gymtrainee.utils.AppConstants;


@Database(entities = {VideoEntity.class}, exportSchema = false, version = 860)
public abstract class MyRoomDatabase extends RoomDatabase {

    public static MyRoomDatabase roomDatabase;
    public static synchronized MyRoomDatabase getInstance(Context context){
        if (roomDatabase == null){
            roomDatabase = Room.databaseBuilder(context, MyRoomDatabase.class,
                    AppConstants.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return roomDatabase;
    }

    public abstract VideoDao videoDao();
}
