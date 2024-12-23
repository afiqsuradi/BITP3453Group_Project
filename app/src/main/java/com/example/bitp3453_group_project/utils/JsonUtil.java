package com.example.bitp3453_group_project.utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.example.bitp3453_group_project.data.model.Lab;

public class JsonUtil {

    public static List<Lab> loadLabs(Context context) {
        String jsonString = null;
        try {
            InputStream inputStream = context.getAssets().open("labs_seed.json");
            Log.d("JsonUtil", "Opened labs_seed.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Log.e("JsonUtil", e.getMessage());
            return null;
        }
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Lab>>(){}.getType();
        return gson.fromJson(jsonString, listType);

    }
}