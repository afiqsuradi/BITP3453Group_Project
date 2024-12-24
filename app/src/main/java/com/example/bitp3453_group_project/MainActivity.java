package com.example.bitp3453_group_project;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitp3453_group_project.data.model.Lab;
import com.example.bitp3453_group_project.ui.lab.LabRecyclerViewAdapter;
import com.example.bitp3453_group_project.viewmodel.LabViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView labRecyclerView;
    private LabViewModel labViewModel;
    private LabRecyclerViewAdapter labRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        labViewModel = new ViewModelProvider(this).get(LabViewModel.class);
        labRecyclerView = findViewById(R.id.labRecyclerView);
        labRecyclerViewAdapter = new LabRecyclerViewAdapter(this, null);
        labRecyclerView.setAdapter(labRecyclerViewAdapter);
        labRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        labViewModel.getAllLabs().observe(this, labs -> {
            labRecyclerViewAdapter.setLabs(labs);
        });

    }
}