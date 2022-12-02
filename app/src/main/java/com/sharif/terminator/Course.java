package com.sharif.terminator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {
    private final String info;
    private final String course_id;
    private final String course_number;
    private final String name;
    private final int units;
    private final int capacity;
    private final String instructor;
    private final String class_times;
    private final int id;
    private final String exam_time;
    private final float classTimeBeginning;
    private final float classTimeEnding;
    private final int classFirstDate;
    private final int classSecondDate;
    private int datePriority;

    public Course(String info, String course_id, String course_number, String name, int units, int capacity, String instructor, String class_times, int id, String exam_time) {
        this.info = info;
        this.course_id = course_id;
        this.course_number = course_number;
        this.name = name;
        this.units = units;
        this.capacity = capacity;
        this.instructor = instructor;
        this.class_times = class_times;
        this.id = id;
        this.exam_time = exam_time;
        this.datePriority = 1;

        Pattern pattern = Pattern.compile("\\[\\{\"start\": ([0-9.]+), \"end\": ([0-9.]+), \"day\": ([0-9])\\}, \\{\"start\": [0-9.]+, \"end\": [0-9.]+, \"day\": ([0-9])\\}\\]");
        Matcher matcher = pattern.matcher(class_times);
        if (matcher.find()) {
            this.classTimeBeginning = Float.parseFloat(matcher.group(1));
            this.classTimeEnding =Float.parseFloat(matcher.group(2));
            this.classFirstDate = Integer.parseInt(matcher.group(3));
            this.classSecondDate = Integer.parseInt(matcher.group(4));
        } else {
            this.classTimeBeginning = -1;
            this.classTimeEnding = -1;
            this.classFirstDate = -1;
            this.classSecondDate = -1;
        }
    }

    public String getInfo() {
        return info;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_number() {
        return course_number;
    }

    public String getName() {
        return name;
    }

    public int getUnits() {
        return units;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getClass_times() {
        return class_times;
    }

    public int getId() {
        return id;
    }

    public String getExam_time() {
        return exam_time;
    }

    public Float getClassTimeBeginning() {
        return classTimeBeginning;
    }

    public Float getClassTimeEnding() {
        return classTimeEnding;
    }

    public int getClassFirstDate() {
        return classFirstDate;
    }

    public int getClassSecondDate() {
        return classSecondDate;
    }

    public void setDatePriority(int datePriority) {
        this.datePriority = datePriority;
    }

    public int getClassDate() {
        if (datePriority == 1) {
            return classFirstDate;
        }
        return classSecondDate;
    }
    
    public static Course getClone(Course course) {
        return new Course(course.info, course.course_id, course.course_number, course.name, course.units, course.capacity, course.instructor, course.class_times, course.id, course.exam_time);
    }
}
