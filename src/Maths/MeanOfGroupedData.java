package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MeanOfGroupedData {

    public static void main (String[] args) {
        Table dataSet = new Table(10, 80,7);
        System.out.println("Mean: " + dataSet.getMean());
        System.out.println("Median: " + dataSet.getMedian());
        System.out.println("Mode: " + dataSet.getMode());
        System.out.println("Variance: " + dataSet.getVariance());
        System.out.println("Standard deviation: " + dataSet.getStandardDeviation());
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
    private double tfm; // frequency * ((midpoint - mean) ^ 2)
    public Table(int lower , int upper , int numOfClasses , boolean flag){
        classesList = new ArrayList<>();
        this.generateTable(lower , upper , numOfClasses , flag);
        this.initVariable();
    }
    public Table(int lower , int upper , int numOfClasses){
        this(lower , upper , numOfClasses , false);
    }
    private void generateTable(int lower , int upper , int numOfClasses , boolean flag){
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
            if (flag)++lower;
            lower += this.classLength;
        }
        if (flag)++classLength;
    }
    public double getVariance(){
        return tfm / totalFrequency;
    }
    public double getStandardDeviation(){
        return Math.sqrt(this.getVariance());
    }
    public double getMode(){
        int l = 0; // lower class boundary of the modal group
        int prevFreq = 0; //the frequency of the group before the modal group
        int f = Integer.MIN_VALUE; //the frequency of the modal group
        int nextFreq = 0; //the frequency of the group after the modal group
        for (int i = 1; i < classesList.size(); i++) {
            if (classesList.get(i).getFrequency() > f){
                l = classesList.get(i).getLower();
                f = classesList.get(i).getFrequency();
                if (i > 0 && i < classesList.size() - 1){
                    prevFreq = classesList.get(i - 1).getFrequency();
                    nextFreq = classesList.get(i + 1).getFrequency();
                }
            }
        }
        return l + ((f - prevFreq) / (double)( (f - prevFreq) + (f - nextFreq) )) * this.classLength;
        //return (3 * this.getMedian()) - (2 * getMean()); you can use this instead.
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
        var mean = getMean();
        for (Classes c : classesList){
            tfm += c.getFrequency() * Math.pow((c.getMidPoint() - mean) , 2);
        }
    }
}