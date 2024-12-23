package com.example.bitp3453_group_project.data.dao;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bitp3453_group_project.data.model.Item;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    long insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM items WHERE id = :itemId")
    LiveData<Item> getItemById(int itemId);

    @Query("SELECT * FROM items WHERE lab_id = :labId")
    LiveData<List<Item>> getItemsByLabId(int labId);

    @Query("SELECT * FROM items")
    LiveData<List<Item>> getAllItems();


    @Query("SELECT * FROM items WHERE lab_id = :labId AND (name LIKE '%' || :query || '%' OR serial_number LIKE '%' || :query || '%')")
    LiveData<List<Item>> searchItemsByLab(int labId, String query);

    @Query("SELECT * FROM items WHERE name LIKE '%' || :query || '%' OR serial_number LIKE '%' || :query || '%'")
    LiveData<List<Item>> searchItems(String query);

}