package com.example.seadgacanovic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {users.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {
    private static UsersDatabase INSTANCE;
    public abstract usedDao usedDao();

    public static UsersDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), UsersDatabase.class, "user-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
