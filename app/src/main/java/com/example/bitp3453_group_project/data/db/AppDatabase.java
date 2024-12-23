package com.example.bitp3453_group_project.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.bitp3453_group_project.data.dao.ItemDao;
import com.example.bitp3453_group_project.data.dao.LabDao;
import com.example.bitp3453_group_project.data.model.ConditionConverter;
import com.example.bitp3453_group_project.data.model.Item;
import com.example.bitp3453_group_project.data.model.Lab;


@Database(entities = {Lab.class, Item.class}, version = 1, exportSchema = false)
@TypeConverters({ConditionConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract LabDao labDao();
    public abstract ItemDao itemDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "lab_inventory_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}