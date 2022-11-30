package com.sharif.terminator;

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
}
