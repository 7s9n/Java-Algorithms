package LinearAlgebra;


import java.util.Arrays;

public class MatrixMultiplication {
    public static int[][] multiply(int[][] a , int[][] b){
        int aRows = a.length , aCols = a[0].length;
        int bRows = b.length , bCols = b[0].length;
        if (aCols != bRows)
            throw new IllegalArgumentException("The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.");
        //The result will have the same number of rows as the 1st matrix, and the same number of columns as the 2nd matrix.
        int[][] ans = new int[aRows][bCols];
        // Note : (matrix multiplication is not commutative).
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++)
                for (int k = 0; k < aCols; k++)
                    ans[i][j] += a[i][k] * b[k][j];
        }
        return ans;
    }

    public static void main (String[] args) {
        int[][] a = new int[][]{
            {1 , 2 , 3}
        };
        int[][] b = new int[][]{
            {4},
            {5},
            {6}
        };
        for (int[] row : multiply(a , b))
            System.out.println(Arrays.toString(row));
    }
}
