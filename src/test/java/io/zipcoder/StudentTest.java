package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String actualOutput = student.getExamScores();
        String expectedOutput = "Exam 1 -> 100\n" +
                "Exam 2 -> 95\n" +
                "Exam 3 -> 123\n"+
                "Exam 4 -> 96\n";
        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void addExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String actualOutput = student.getExamScores();

        String expectedOutput = "Exam 1 -> 100\n";

        // Then
        Assert.assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void setExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        int actualOutput = student.getAverageExamScore();

        // Then
        Assert.assertEquals(125,actualOutput);
    }
    @Test
    public void toStringTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String actualOutput = student.returnString();
        String expectedOutput = "Student Name: Leon Hunter\n"+
                "> Average Score: 125\n"+
                "> Exam Scores:\n"+
                "Exam 1 -> 100\n"+
                "Exam 2 -> 150\n"+
                "Exam 3 -> 250\n"+
                "Exam 4 -> 0\n";
        // Then
        Assert.assertEquals(expectedOutput,actualOutput);
    }
}