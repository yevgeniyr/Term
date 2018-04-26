package com.wgu.yevgeniy.term;

import java.util.ArrayList;
import java.util.Objects;

public class Term {
    String name;
    ArrayList<Course> listCourses;
    String startDate;
    String endDate;

    public Term(String name) {
        this.name = name;
        listCourses = new ArrayList<Course>();
        listCourses.add(new Course("physics"));
        listCourses.add(new Course("math"));
        listCourses.add(new Course("comp212"));
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ArrayList<Course> getCourses() {
        return listCourses;
    }

    public void setListCourses(ArrayList<Course> listCourses) {
        this.listCourses = listCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return Objects.equals(name, term.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

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
}
