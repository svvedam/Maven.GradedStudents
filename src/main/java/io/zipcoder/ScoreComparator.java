package io.zipcoder;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {

        return o2.getTotalScore().compareTo(o1.getTotalScore());
    }
}

