package com.sharif.terminator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeaklyChartFragment extends Fragment {

    private RelativeLayout weaklyLayout;
    private RecyclerView weaklyChartView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        weaklyLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_weakly_chart, container, false);
        weaklyChartView = weaklyLayout.findViewById(R.id.weakly_chart_view);

        ArrayList<Course> selectedCourseTimes = new ArrayList<>();
        selectedCourseTimes = SelectedCourse.getSelectedCourses();

        WeaklyChartRecyclerAdapter adapter = new WeaklyChartRecyclerAdapter();
        adapter.setSelectedCoursesTimes(selectedCourseTimes);

        weaklyChartView.setAdapter(adapter);
        weaklyChartView.setLayoutManager(new LinearLayoutManager(getContext()));

        return weaklyLayout;
    }
}
