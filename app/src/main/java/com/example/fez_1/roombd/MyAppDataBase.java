package com.example.fez_1.roombd;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;




@Database(entities = {Items.class}, version = 2)
public abstract class MyAppDataBase extends RoomDatabase {
    public abstract MayDao daoAccess() ;



}
