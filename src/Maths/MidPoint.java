package Maths;

public class MidPoint {
    public static void main (String[] args) {
        System.out.println(getMidPoint(50 , 60)); // 55.0
    }

    /**
     *
     * @param lowerBoundary argument
     * @param upperBoundary argument
     * @return  class midpoint.
     */
    public static double getMidPoint(int lowerBoundary , int upperBoundary){
        if (lowerBoundary > upperBoundary){
            throw new RuntimeException("Lower boundary is greater than the upper boundary");
        }
        return (lowerBoundary + upperBoundary) / 2;
    }
}
