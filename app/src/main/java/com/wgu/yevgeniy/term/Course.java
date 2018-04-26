package com.wgu.yevgeniy.term;

public class Course {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Course(String name) {
        this.name = name;
    }
}
