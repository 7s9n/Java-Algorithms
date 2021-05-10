package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MeanOfGroupedData {

    public static void main (String[] args) {
        Table dataSet = new Table(22 , 32,5);
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
    public Classes (int lower, int upper , int frequency){
        this.classes = new Pair(lower , upper);
        this.frequency = frequency;
    }
    public double getFrequency(){
        return this.frequency;
    }
    public double getMidPoint(){
        return (this.classes.getUpper() + this.classes.getLower()) / 2.0;
    }
    @Override
    public String toString(){
        return this.classes.getLower() + " - " + this.classes.getUpper();
    }
}
class Table{
    private List<Classes> classesList;
    private int totalFrequency;
    private double totalFrequencyMulByMid;
    public Table(int lower , int upper , int numOfClasses){
        classesList = new ArrayList<>();
        this.generateTable(lower , upper , numOfClasses);
        this.initVariable();
    }
    private void generateTable(int lower , int upper , int numOfClasses){
        int range = upper - lower , classLength = Math.round(range / numOfClasses) , freq = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
    public double getMedian(){
        int l = 0 ; //lower limit of the median class.
        int f = 0 ; //frequency of the median class.
        int F = 0 ; //cumulative frequency of the class preceding the median class.
        int n = 0 ; //total number of observations / frequency.
        int h = 0 ; //width of the median class.
        for (Classes c : classesList){

        }
        return 00.0;
    }
    public double getMean(){
        return totalFrequencyMulByMid / this.totalFrequency;
    }
    private void initVariable(){
        for (Classes c : classesList){
            totalFrequency += c.getFrequency();
            totalFrequencyMulByMid += c.getFrequency() * c.getMidPoint();
        }
    }
}