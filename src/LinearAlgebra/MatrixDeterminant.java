package LinearAlgebra;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import static Utils.TestUtils.getRandomMatrix;
public class MatrixDeterminant {
    public static int det(int[][] matrix){
        int n = matrix.length;
        if ( (n == 0 || n != matrix[0].length))
            throw new IllegalArgumentException();
        if (n == 1)
            return matrix[0][0]; // for 1x1 determinant.
        if (n == 2)
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]); //for 2x2 determinant.
        // For 3x3 matrices and up use Laplace/cofactor expansion.
        return laplace(matrix);
    }
    private static int laplace(int[][] matrix){
        int n = matrix.length;
        // Base case is 3x3 determinant
        if (n == 3){
            /*
             * Used as a temporary variables to make calculation easy
             * | a  b  c |
             * | d  e  f |
             * | g  h  i |
             */
            int a = matrix[0][0] , b = matrix[0][1] , c = matrix[0][2];
            int d = matrix[1][0] , e = matrix[1][1] , f = matrix[1][2];
            int g = matrix[2][0] , h = matrix[2][1] , i = matrix[2][2];
            return a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);
        }
        int det = 0;
        for (int i = 0; i < n; i++) {
            int c = matrix[0][i];
            if (c != 0){
                int sign = ((i & 1) == 0) ? +1 : -1;
                det += sign * matrix[0][i] * det( createSubMatrix(matrix ,0 , i) );
            }
        }
        return det;
    }

    /**
     * This method exclude given row and column then construct a new matrix ,
     * without the excluded row and column.
     * The Laplace expansion is computationally inefficient for high dimension matrices.
     */
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
    private static void printMatrix(int[][] mat){
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
    public static void main (String[] args) {
        int[][] mat1 = new int[][]{
                {1 , 3 , 5 , 9},
                {1 , 3 , 1 , 7},
                {4 , 3 , 9 , 7},
                {5 , 2 , 0 , 9},
        }; // det(mat1) = -376 , mat(4 * 4)
        int[][] mat2 = new int[][]{
                {1 , 3 , 5 , 4},
                {2 , 3 , 1 , 3},
                {4 , 3 , 9 , 7},
                {5 , 2 , 6 , 9},
        }; // det(mat2) = -152 , mat(4 * 4)
        int[][] mat3 = new int[][]{
                {4 , 7 , 2 , 3},
                {1 , 3 , 1 , 2},
                {2 , 5 , 3 , 4},
                {1 , 4 , 2 , 3},
        }; // det(mat3) = -3 , mat(4 * 4)
        int[][] mat4 = new int[][]{
                {1 , 0 , 0 , 0 , 0 , 2},
                {0 , 1 , 0 , 0 , 2 , 0},
                {0 , 0 , 1 , 2 , 0 , 0},
                {0 , 0 , 2 , 1 , 0 , 0},
                {0 , 2 , 0 , 0 , 1 , 0},
                {2 , 0 , 0 , 0 , 0 , 1},
        }; // det(mat4) = -27 , mat(6 * 6)
        int[][] mat5 = new int[][]{
                {1 , 1 , 9 , 3 , 1 , 2 , 3},
                {9 , 1 , 8 , 4 , 2 , 3 , 1},
                {3 , 2 , 7 , 2 , 9 , 5 , 5},
                {4 , 6 , 2 , 1 , 7 , 9 , 6},
                {5 , 3 , 1 , 3 , 1 , 5 , 3},
                {2 , 7 , 9 , 5 , 0 , 1 , 2},
                {2 , 1 , 3 , 8 , 9 , 1 , 4}
        }; // det(mat5) = 66704 mat(7 * 7)
        int[][] mat6 = new int[][]{
                {1 , 1 , 9 , 3 , 1 , 2 , 3 , 9},
                {9 , 1 , 8 , 4 , 2 , 3 , 1 , 8},
                {3 , 2 , 7 , 2 , 9 , 5 , 5 , 7},
                {4 , 6 , 2 , 1 , 7 , 9 , 6 , 6},
                {5 , 3 , 1 , 3 , 1 , 5 , 3 , 5},
                {2 , 7 , 9 , 5 , 0 , 1 , 2 , 4},
                {2 , 1 , 3 , 8 , 9 , 1 , 4 , 3},
                {6 , 1 , 6 , 7 , 9 , 1 , 4 , 2}
        }; // det(mat6) = -39240 , mat(8 * 8)
        int[][] mat7 = new int[][]{
                {1 , 1 , 9 , 3 , 1 , 2 , 3 , 9 , 1},
                {9 , 1 , 8 , 4 , 2 , 3 , 1 , 8 , 2},
                {3 , 2 , 7 , 2 , 9 , 5 , 5 , 7 , 3},
                {4 , 6 , 2 , 1 , 7 , 9 , 6 , 6 , 4},
                {5 , 3 , 1 , 3 , 1 , 5 , 3 , 5 , 5},
                {2 , 7 , 9 , 5 , 0 , 1 , 2 , 4 , 6},
                {2 , 1 , 3 , 8 , 9 , 1 , 4 , 3 , 7},
                {6 , 1 , 6 , 7 , 9 , 1 , 4 , 2 , 8},
                {9 , 8 , 7 , 4 , 3 , 3 , 4 , 2 , 9}
        }; // det(mat7) = 1910870 , mat( 9 * 9)
        int[][] mat0 = new int[][]{
                {1 , 2 , 4 , 8 , 6 , 3 , 4 , 8 , 0 , 2},
                {2 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 1},
                {5 , 2 , 3 , 4 , 8 , 9 , 1 , 9 , 8 , 3},
                {1 , 1 , 1 , 6 , 4 , 2 , 5 , 9 , 8 , 7},
                {9 , 5 , 0 , 1 , 2 , 0 , 6 , 0 , 0 , 0},
                {8 , 4 , 0 , 1 , 2 , 3 , 4 , 5 , 8 , 4},
                {7 , 3 , 3 , 6 , 7 , 8 , 9 , 1 , 7 , 3},
                {1 , 2 , 4 , 0 , 0 , 0 , 0 , 3 , 5 , 2},
                {1 , 1 , 0 , 4 , 5 , 0 , 0 , 4 , 2 , 1},
                {1 , 0 , 0 , 0 , 9 , 0 , 0 , 1 , 1 , 6}
        }; // det(mat0) = 17265530
        int[][] mat11 = getRandomMatrix(13, 13); // for 13 * 13 it took 381 seconds , 6.35 minutes
        Instant start = Instant.now();
        System.out.println(det(mat1));
        System.out.println(det(mat2));
        System.out.println(det(mat3));
        System.out.println(det(mat4));
        System.out.println(det(mat5));
        System.out.println(det(mat6));
        System.out.println(det(mat7));
        System.out.println(det(mat0));
        System.out.println(det(mat11));
        Instant finish = Instant.now();
        System.out.println("Elapsed time: " + Duration.between(start , finish).toSeconds() + " seconds");
    }
}
