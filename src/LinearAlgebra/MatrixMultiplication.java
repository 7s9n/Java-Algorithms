package LinearAlgebra;


public class MatrixMultiplication {
    @SuppressWarnings("unchecked")
    public static Integer[][] multiply(int[][] a , int[][] b){
        int aRows = a.length, aCols = a[0].length;
        int bRows = b.length, bCols = b[0].length;
        if (aCols != bRows)
            return null;
        Object[][] res = new Object[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                for (int k = 0; k < aCols; k++)
                    res[i][j] = a[i][k] * b[k][j];
            }
        }
        return ((Integer[][])res);
    }

    private Object[][] multiply(Object[][] a  , Object[][] b){
        int aRows = a.length, aCols = a[0].length;
        int bRows = b.length, bCols = b[0].length;
        if (aCols != bRows)
            return null;
        Object[][] res = new Object[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                for (int k = 0; k < aCols; k++)
                    res[i][j] += mlt((double) a[i][k] , (double)b[k][j]);
            }
        }
        return res;
    }
    private double mlt(double a , double b){
        return a * b;
    }
}
