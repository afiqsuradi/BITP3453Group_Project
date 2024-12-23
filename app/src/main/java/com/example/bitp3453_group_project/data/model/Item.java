package com.example.bitp3453_group_project.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.bitp3453_group_project.data.ItemCondition;

import java.util.Date;

@Entity(tableName = "items",
        foreignKeys = @ForeignKey(entity = Lab.class,
                parentColumns = "id",
                childColumns = "lab_id",
                onDelete = ForeignKey.CASCADE)
)
public class Item {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "lab_id")
    private int labId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "serial_number")
    private String serialNumber;

    @TypeConverters(ConditionConverter.class)
    @ColumnInfo(name = "condition")
    private ItemCondition condition;

    @ColumnInfo(name = "created_at")
    private Date createdAt;

    @ColumnInfo(name="updated_at")
    private Date updatedAt;


    // Constructors
    public Item() {
        this.createdAt= new Date();
        this.updatedAt= new Date();
    }

    public Item(int labId, String name, String serialNumber, ItemCondition condition) {
        this.labId = labId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.condition = condition;
        this.createdAt= new Date();
        this.updatedAt= new Date();
    }
    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}