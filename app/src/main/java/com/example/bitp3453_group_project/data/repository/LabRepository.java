package com.example.bitp3453_group_project.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.bitp3453_group_project.data.dao.LabDao;
import com.example.bitp3453_group_project.data.db.AppDatabase;
import com.example.bitp3453_group_project.data.model.Lab;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LabRepository {

    private LabDao labDao;
    private LiveData<List<Lab>> allLabs;
    private ExecutorService executorService;

    public LabRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        labDao = database.labDao();
        allLabs = labDao.getAllLabs();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Lab lab) {
        executorService.execute(()->labDao.insert(lab));
    }

    public void update(Lab lab) {
        executorService.execute(()->labDao.update(lab));
    }

    public void delete(Lab lab) {
        executorService.execute(()->labDao.delete(lab));
    }

    public LiveData<Lab> getLabById(int labId) {
        return labDao.getLabById(labId);
    }


    public LiveData<List<Lab>> getAllLabs() {
        return allLabs;
    }

    public LiveData<List<Lab>> searchLabs(String query){
        return labDao.searchLabs(query);
    }
}