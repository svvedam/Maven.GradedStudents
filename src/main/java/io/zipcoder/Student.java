package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    public String firstName;
    public String lastName;

    public Double totalScore;

    public ArrayList<Double> examScores;

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore() {
        double doubleSum = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            doubleSum += examScores.get(i);
        }

        this.totalScore = doubleSum;
    }


    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(examScores));
        setTotalScore();
    }
    public Student(){}

    public int getNumberOfExamsTaken(){
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAverageExamScore(){
        double doubleSum= 0.0;
        for(Double dbl: examScores){
            doubleSum +=dbl;
        }
        Double average = doubleSum/examScores.size();
        int returnInt = average.intValue();
        return returnInt;
    }

    protected String returnString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append("Student Name: ");
        sbr.append(this.firstName);
        sbr.append(" ");
        sbr.append(this.lastName);
        sbr.append("\n");
        sbr.append("> Average Score: ");
        sbr.append(getAverageExamScore());
        sbr.append("\n");
        sbr.append("> Exam Scores:");
        sbr.append("\n");
        sbr.append(getExamScores());
        return sbr.toString();
    }

    public void setExamScore(int examNumber, double newScore) {
        examNumber = examNumber - 1;
        this.examScores.set(examNumber, newScore);
    }
    public String getExamScores(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<examScores.size();i++){
            int temp = (int)Math.round(examScores.get(i));

            sb.append("Exam ");
            sb.append(i+1);
            sb.append(" -> ");
            sb.append(temp);
            sb.append("\n");
        }
        return sb.toString();
    }
    public void addExamScore(double examScore){

        this.examScores.add(examScore);
    }
}
