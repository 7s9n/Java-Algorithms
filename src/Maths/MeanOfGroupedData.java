package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MeanOfGroupedData {

    public static void main (String[] args) {
        Table dataSet = new Table(20 , 100,8);
        System.out.println("Mean: " + dataSet.getMean());
    }
}
class Pair{
    private int lower;
    private int upper;

    public Pair (int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
    public int getLower () {
        return lower;
    }

    public int getUpper () {
        return upper;
    }
}
class Classes{
    private final Pair classes;
    private final int frequency;
    private final double midPoint;
    private double frequencyMultipliedByMidPoint;
    public Classes (int lower, int upper , int frequency){
        this.classes = new Pair(lower , upper);
        this.frequency = frequency;
        this.midPoint = (lower + upper) / 2;
        this.frequencyMultipliedByMidPoint = this.frequency * this.midPoint;
    }
    public double getFrequency(){
        return this.frequency;
    }
    public double getFrequencyMultipliedByMidPoint(){
        return this.frequencyMultipliedByMidPoint;
    }
    @Override
    public String toString(){
        return this.classes.getLower() + " - " + this.classes.getUpper();
    }
}
class Table{
    private List<Classes> classesList;

    public Table(int lower , int upper , int numOfClasses){
        classesList = new ArrayList<>();
        this.generateTable(lower , upper , numOfClasses);
    }
    private void generateTable(int lower , int upper , int numOfClasses){
        int range = upper - lower , classLength = Math.round(range / numOfClasses) , freq = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Length: " + classLength);
        for (int i = 0; i < numOfClasses; i++) {
            System.out.print("Enter frequency of " + lower + " - " + (lower + classLength) + ": ");
            try {
                freq = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                //Handle exception ....
            }
            classesList.add(new Classes(lower , lower + classLength , freq));
            lower += classLength;
        }
    }
    public double getMean(){
        double totalFreq = 0 , totalFreqMulMid = 0;
        for (Classes c : classesList){
            totalFreq += c.getFrequency() ;
            totalFreqMulMid += c.getFrequencyMultipliedByMidPoint();
        }
        return  totalFreqMulMid / totalFreq;
    }
}