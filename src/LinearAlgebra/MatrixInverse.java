package LinearAlgebra;

import java.util.Arrays;

public class MatrixInverse {
    private static int determinant(int[][] mat){
        int n = mat.length;
        if (n == 2)
            return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        int det = 0;
        for (int i = 0; i < n; i++) {
            int sign = ((i & 1) == 0) ? +1 : -1;
            det += sign * mat[0][i] * determinant( createSubMatrix(mat ,0 , i) );
        }// end of for
        return det;
    } // end of determinant
    private static int[][] createSubMatrix(int[][] mat , int excludingRow , int excludingCol){
        int n = mat.length;
        int[][] newMatrix = new int[n - 1][n - 1];
        int rPtr = -1;
        for (int i = 0; i < n; i++) {
            if (i == excludingRow)continue;
            ++rPtr;
            int cPtr = -1;
            for (int j = 0; j < n; j++) {
                if (j == excludingCol)continue;
                newMatrix[rPtr][++cPtr] = mat[i][j];
            } // end of inner loop
        } // end of outer loop
        return newMatrix;
    } // end of createSubMatrix
    private static int[][] cofactor(int[][] mat){
        int n = mat.length;
        int[][] cofactorMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int changeSign = ((j & 1) == 0) ? 1 : -1;
                int sign = ((i & 1) == 0) ? 1 : -1;
                cofactorMatrix[i][j] = sign * changeSign * determinant(createSubMatrix(mat , i , j));
            } // end of inner loop
        }// end of outer loop
        return cofactorMatrix;
    }
    private static float[][] multiplyByConstant(int[][] mat , float constant){
        int n = mat.length;
        float[][] newMatrix = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = constant * mat[i][j];
            } // end of inner
        }// end of outer
        return newMatrix;
    }
    private static int[][] transpose(int[][] mat){
        int n = mat.length;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++)
                swap(mat , i , j);
        } // end of outer loop
        return mat;
    }

    private static void swap (int[][] mat, int i, int j) {
        int tmp = mat[j][i];
        mat[j][i] = mat[i][j];
        mat[i][j] = tmp;
    }
    public static float[][] inverseOf(int[][] mat){
        int n = mat.length;
        int det = determinant(mat);
        // Check to see if matrix is singular
        if (det == 0)
            throw new IllegalArgumentException("Determinant of matrix equals 0, no inverse exists");
        if (n == 1)
            throw new IllegalArgumentException("Matrix is a vector");
        if (n == 2){
            // Compute inverse matrix elements 2*2 matrix
            float[][] ans = new float[n][n]; // Collect the results into a new matrix
            ans[0][0] = (float)mat[1][1] / det;
            ans[0][1] = (float)-mat[0][1] / det;
            ans[1][0] = (float)-mat[1][0] / det;
            ans[1][1] = (float) mat[0][0] / det;
            return ans;
        }
        // inverse matrix for 3*3 and up
        return multiplyByConstant(transpose(cofactor(mat)) , 1.0f / det );
    }

    public static void main (String[] args) {
        int[][] mat = new int[][]{
                {3 , 0 , 2},
                {2 , 0 , -2},
                {0 , 1 , 1},
        };
        int[][] mat2 = new int[][]{
                {5 , 2},
                {-7 , 3}
        };
        int[][] mat3 = new int[][]{
                {2 , 5 , 0 , 8},
                {1 , 4 , 2 , 6},
                {7 , 8 , 9 , 3},
                {1 , 5 , 7 , 8}
        };
        int[][] mat4 = new int[][]{
                {2 , 5 , 0 , 8 , 9},
                {1 , 4 , 2 , 6 , 6},
                {7 , 8 , 9 , 3 , 8},
                {1 , 5 , 7 , 8 , 1},
                {8 , 9 , 7 , 6 , 5}
        };
        for (float[] row : inverseOf(mat2))
            System.out.println(Arrays.toString(row));
    }
}
