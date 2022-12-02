package com.sharif.terminator;

import java.util.ArrayList;

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
            return true;
        }
        if (selectedCourses.size() == 0) {
            selectedCourses.add(firstCourse);
            selectedCourses.add(secondCourse);
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
        return true;
    }
}

