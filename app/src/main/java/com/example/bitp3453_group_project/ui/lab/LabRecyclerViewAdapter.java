package com.example.bitp3453_group_project.ui.lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitp3453_group_project.R;
import com.example.bitp3453_group_project.data.model.Lab;

import java.util.List;

public class LabRecyclerViewAdapter extends RecyclerView.Adapter<LabRecyclerViewAdapter.LabViewHolder> {
    private final Context context;
    private List<Lab> labs;

    public LabRecyclerViewAdapter(Context context, List<Lab> labs) {
        this.context = context;
        this.labs = labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LabRecyclerViewAdapter.LabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lab_recycler_view, parent, false);
        return new LabRecyclerViewAdapter.LabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LabRecyclerViewAdapter.LabViewHolder holder, int position) {
        holder.labNameTextview.setText(labs.get(position).getName());
        holder.labCodeTextview.setText(labs.get(position).getCode());
        holder.labSupervisorTextview.setText(labs.get(position).getSupervisor());
    }

    @Override
    public int getItemCount() {
        return labs == null ? 0 : labs.size();
    }

    public class LabViewHolder extends RecyclerView.ViewHolder{

        private TextView labNameTextview;
        private TextView labCodeTextview;
        private TextView labSupervisorTextview;

        public LabViewHolder(@NonNull View itemView) {
            super(itemView);
            labNameTextview = itemView.findViewById(R.id.labNameTextview);
            labCodeTextview = itemView.findViewById(R.id.labCodeTextview);
            labSupervisorTextview = itemView.findViewById(R.id.labSupervisorTextview);
        }
    }
}
