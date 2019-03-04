package io.zipcoder;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {

        return o2.getLastName().compareTo(o1.getLastName());
    }
}
