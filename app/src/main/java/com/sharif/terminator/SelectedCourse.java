package com.sharif.terminator;

import java.util.ArrayList;

public class SelectedCourse {
    private ArrayList<Course> selectedCourses = new ArrayList<>();

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void addSelectedCourse(Course course) {
        selectedCourses.add(course);
    }
}

