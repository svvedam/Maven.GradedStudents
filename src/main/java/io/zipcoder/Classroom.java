package io.zipcoder;

import java.util.*;
import io.zipcoder.Student;

public class Classroom {
    public Student[] students;

    Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    Classroom(Student[] studentsCollection) {
        this.students = studentsCollection;
    }

    //Define nullary constructor which initializes the
    // composite students object to be an empty array of 30 Student objects.
    Classroom(){
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double doubleAvgSum = 0.0;
        for (Student s : students) {
            s.setTotalScore();
            doubleAvgSum += s.getTotalScore();
        }
        Double averageExamScore = doubleAvgSum / students.length;
        return averageExamScore;
    }

    public void addStudent(Student student) {

        students[0] = student;
    }

    public void removeStudent(String firstName, String lastName) {
        Student temp;
        for (int i = 0; i < students.length-1; i++) {
            if (students[i].firstName.equals(firstName) &&
                    students[i].lastName.equals(lastName)) {
                temp = students[i];
                students[i] = students[i + 1];
                students[i + 1] = temp;
            }
        }
    }
    public Student[] getStudentsByScore(){
        Comparator<Student> lastNameComparator =(Comparator<Student>)new NameComparator();
        Comparator<Student> scoreComparator = (Comparator<Student>)new ScoreComparator();
        Double s1TotalScore = students[0].getTotalScore();
        Double s2TotalScore = students[0].getTotalScore();
        StudentSorter studentSorter = new StudentSorter(students);
        Student[] actualResult;
        if (s1TotalScore!=s2TotalScore)
            actualResult = studentSorter.sort(scoreComparator);
        else
            actualResult = studentSorter.sort(lastNameComparator);
        return actualResult;
    }
    public String getGradeBook(){
        double avg = 0;
        StringBuilder sbr = new StringBuilder();

       Map<String,String> gradeMap = new TreeMap<String,String>();
       for(int i =0 ; i<students.length; i++){
           avg= students[i].getAverageExamScore();
           String grade = calculateGrade(avg);
           gradeMap.put(students[i].lastName,grade);
       }
       for(Map.Entry<String,String> entry: gradeMap.entrySet()){
           sbr.append("Student name : ");
           sbr.append(entry.getKey());
           sbr.append(" Grade is : ");
           sbr.append(entry.getValue());
           sbr.append("\n");
       }
       return sbr.toString();
    }

    public String calculateGrade(double avg){
        /*A average is in the upper 10th percentile.
        B average falls between the 11th and 29th percentile.
        C average falls between the 30th and 50th percentile.
        D average falls between the 51st and 89th percentile.
        F average is in the lower 11th percentile.*/
        double totalAvg=0;
        String returnGrade;
        for(int i=0;i<students.length;i++){
            totalAvg+=students[i].getAverageExamScore();
        }
        Double finalPercentile = Double.valueOf((avg/totalAvg)*100);
        if(finalPercentile>=24 && finalPercentile <=30)
            returnGrade = "A";
        else if(finalPercentile>=21 && finalPercentile <=23)
            returnGrade = "B";
        else if(finalPercentile>=18 && finalPercentile <=20)
            returnGrade = "C";
        else if(finalPercentile>=16 && finalPercentile <=17)
            returnGrade = "D";
        else if(finalPercentile>=10 && finalPercentile <=15)
            returnGrade = "F";
        else
            returnGrade ="invalid";

        return returnGrade;
    }

}
