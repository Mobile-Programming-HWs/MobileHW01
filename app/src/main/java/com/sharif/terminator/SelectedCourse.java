package com.sharif.terminator;

import org.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SelectedCourse {
    private static ArrayList<Course> selectedCourses = new ArrayList<>();

    public static ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public static boolean addSelectedCourse(Course course) {
        Course firstCourse = Course.getClone(course);
        Course secondCourse = Course.getClone(course);
        firstCourse.setDatePriority(1);
        secondCourse.setDatePriority(2);
        if (firstCourse.getClassDate() == -1) {
            selectedCourses.add(firstCourse);
            sortArray();
            return true;
        }
        if (selectedCourses.size() == 0) {
            selectedCourses.add(firstCourse);
            selectedCourses.add(secondCourse);
            sortArray();
            return true;
        }
        for (int i = 0; i < selectedCourses.size(); i++) {
            Course index_course = selectedCourses.get(i);
            if (firstCourse.getClassDate() == index_course.getClassDate()) {
                if (firstCourse.getClassTimeBeginning() <= index_course.getClassTimeEnding() && firstCourse.getClassTimeBeginning() >= index_course.getClassTimeBeginning()) {
                    return false;
                }
                if (firstCourse.getClassTimeEnding() >= index_course.getClassTimeBeginning() && firstCourse.getClassTimeEnding() <= index_course.getClassTimeEnding()) {
                    return false;
                }
            }
        }
        selectedCourses.add(firstCourse);
        selectedCourses.add(secondCourse);
        sortArray();
        return true;
    }

    public static Comparator<Course> comparator = new Comparator<Course>() {
        public int compare(Course s1, Course s2) {

            int rollno1 = s1.getClassDate() * 100 + Math.round(s1.getClassTimeBeginning());
            int rollno2 = s2.getClassDate() * 100 + Math.round(s2.getClassTimeBeginning());

            return rollno1 - rollno2;
        }
    };

    public static void sortArray() {
        Collections.sort(selectedCourses, SelectedCourse.comparator);
    }
}

