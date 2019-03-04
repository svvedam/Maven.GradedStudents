package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ClassroomTest {

    @Test
    public void getStudentsTest() {
        //Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] studentGroup = {s1, s2};
        Classroom classroom = new Classroom(studentGroup);

        //When
        Student[] actualResult = classroom.getStudents();

        //Then
        Assert.assertEquals("[Lio.zipcoder.Student;@5d6f64b1",actualResult.toString());
    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double actualOutput = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(250,actualOutput,0.01);
    }

   @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then

        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
       String expectedResult = "[Student Name: Leon Hunter\n"+
               "> Average Score: 125\n"+
               "> Exam Scores:\n"+
               "Exam 1 -> 100\n"+
               "Exam 2 -> 150\n"+
               "Exam 3 -> 250\n"+
               "Exam 4 -> 0\n"+
               "]";

       Assert.assertEquals(expectedResult,postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        //When
        classroom.removeStudent(s1.firstName,s1.lastName);
        Student[] actualResult = classroom.getStudents();

        //Then

        Assert.assertEquals("[Lio.zipcoder.Student;@5d6f64b1",actualResult.toString());
    }

    @Test
    public void getStudentsByScoreTest() {
        //Given
        Double[] s1Scores = { 100.0, 100.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        //When
        Student[] actualResult = classroom.getStudentsByScore();

        StringBuilder sbr = new StringBuilder();
        for(int i =0; i<actualResult.length; i++) {
            sbr.append(actualResult[i].firstName);
            sbr.append(" ");
            sbr.append(actualResult[i].lastName);
            sbr.append(" Total Score ");
            sbr.append(actualResult[i].getTotalScore());
            sbr.append("\n");
        }
        String actualResultStr = sbr.toString();
        //Then
        String expectedResult = "student two Total Score 250.0\n"+
        "student one Total Score 200.0\n";

        Assert.assertEquals(expectedResult,actualResultStr);

    }
    @Test
    public void getStudentsByNameTest() {
        //Given
        Double[] s1Scores = { 100.0, 100.0 };
        Double[] s2Scores = { 100.0, 100.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        //When
        Student[] actualResult = classroom.getStudentsByScore();

        StringBuilder sbr = new StringBuilder();
        for(int i =0; i<actualResult.length; i++) {
            sbr.append(actualResult[i].firstName);
            sbr.append(" ");
            sbr.append(actualResult[i].lastName);
            sbr.append(" Total Score ");
            sbr.append(actualResult[i].getTotalScore());
            sbr.append("\n");
        }
        String actualResultStr = sbr.toString();
        //Then
        String expectedResult = "student two Total Score 200.0\n"+
                "student one Total Score 200.0\n";

        Assert.assertEquals(expectedResult,actualResultStr);

    }


    @Test
    public void getGradeBookTest() {
        //Given
        Double[] s1Scores = { 100.0, 100.0 };
        Double[] s2Scores = { 100.0, 50.0 };
        Double[] s3Scores = { 100.0, 30.0 };
        Double[] s4Scores = { 60.0, 50.0 };
        Double[] s5Scores = { 50.0, 40.0 };


        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three",s3Scores);
        Student s4 = new Student("student", "four", s4Scores);
        Student s5 = new Student("student", "five", s5Scores);


        Student[] students = {s1,s2,s3,s4,s5};
        Classroom classroom = new Classroom(students);

        //When
        String actualResult = classroom.getGradeBook();
        String expectedResult = "Student name : five Grade is : F\n" +
                "Student name : four Grade is : D\n" +
                "Student name : one Grade is : A\n" +
                "Student name : three Grade is : C\n" +
                "Student name : two Grade is : B\n";
        //Then
        Assert.assertEquals(expectedResult,actualResult);

    }
}

