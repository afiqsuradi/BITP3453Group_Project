package com.example.bitp3453_group_project.data.model;

import androidx.room.TypeConverter;

import com.example.bitp3453_group_project.data.ItemCondition;

public class ConditionConverter {
    @TypeConverter
    public static ItemCondition fromString(String value) {
        return ItemCondition.valueOf(value);
    }

    @TypeConverter
    public static String itemConditionToString(ItemCondition value) {
        return value.name();
    }
}