package com.example.derrick.p03_classjournal;

import java.io.Serializable;

public class DailyGrade implements Serializable {
    private int weekValue;
    private String grade;

    public DailyGrade(int weekValue, String grade) {
        this.weekValue = weekValue;
        this.grade = grade;
    }

    public int getWeekValue() {
        return weekValue;
    }

    public void setWeekValue(int weekValue) {
        this.weekValue = weekValue;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
