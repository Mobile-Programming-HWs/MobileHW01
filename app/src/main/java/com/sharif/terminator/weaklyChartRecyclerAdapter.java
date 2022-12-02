package com.sharif.terminator;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class weaklyChartRecyclerAdapter extends RecyclerView.Adapter<weaklyChartRecyclerAdapter.ViewHolder> {

    private ArrayList<Course> selectedCoursesTimes = new ArrayList<>();

    public weaklyChartRecyclerAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return selectedCoursesTimes.size();
    }

    public void setSelectedCoursesTimes(ArrayList<Course> selectedCoursesTimes) {
        this.selectedCoursesTimes = selectedCoursesTimes;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.weakly_chart_card_view);
        }
    }
}
