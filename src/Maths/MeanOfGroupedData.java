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
        System.out.println("Median: " + dataSet.getMedian());
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
    public int getFrequency(){
        return this.frequency;
    }
    public double getMidPoint(){
        return (this.classes.getUpper() + this.classes.getLower()) / 2.0;
    }
    public int getLower(){
        return this.classes.getLower();
    }
    @Override
    public String toString(){
        return this.classes.getLower() + " - " + this.classes.getUpper();
    }
}
class Table{
    private List<Classes> classesList;
    private int classLength;
    private int totalFrequency; //total number of observations / frequency.
    private double totalFrequencyMulByMid;
    public Table(int lower , int upper , int numOfClasses){
        classesList = new ArrayList<>();
        this.generateTable(lower , upper , numOfClasses);
        this.initVariable();
    }
    private void generateTable(int lower , int upper , int numOfClasses){
        int range = upper - lower , freq = 0;
        this.classLength = Math.round(range / numOfClasses);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < numOfClasses; i++) {
            System.out.print("Enter frequency of " + lower + " - " + (lower + this.classLength) + ": ");
            try {
                freq = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                //Handle exception ....
            }
            classesList.add(new Classes(lower , (lower + this.classLength) , freq));
            lower += this.classLength;
        }
    }
    public double getMode(){

    }
    public double getMedian(){
        int l; //lower limit of the median class.
        int f; //frequency of the median class.
        int F; //cumulative frequency of the class preceding the median class.
        int prev; // previous Cumulative Frequency
        int cur = classesList.get(0).getFrequency(); // current Cumulative Frequency
        double n = totalFrequency / 2; // Median Class
        for (int i = 1; i < classesList.size(); i++) {
            prev = cur;
            cur = prev + classesList.get(i).getFrequency();
            if (cur > n){
                f = classesList.get(i).getFrequency(); //frequency of the median class.
                F = prev; //cumulative frequency of the class preceding the median class.
                l = classesList.get(i).getLower();
                return l + (((n - F) / f) * classLength);
            }
        }
        return 0.0;
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