package io.zipcoder;

import java.util.*;

public class StudentSorter {

    List<Student> studentList = new ArrayList<Student>();

    private Comparator<Student> comparator;

    public StudentSorter(Student[] studentArray) {
        this.studentList = Arrays.asList(studentArray);
    }

    public Student[] sort(Comparator<Student> comparator) {
        this.comparator = comparator;
        Collections.sort(studentList, comparator);
        Student[] resultList = new Student[studentList.size()];
        resultList = studentList.toArray(resultList);
        return resultList;
    }
}
