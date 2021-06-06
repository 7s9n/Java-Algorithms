package LinearAlgebra;

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
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                int c = ints[j];
                int[][] newMatrix = buildMatrix(matrix, j);
                int sign = ((j & 1) == 0) ? +1 : -1;
                det += sign * c * laplace(newMatrix);
            } // end of inner loop.
        } // end of outer loop.
        return det;
    }

    /**
     * This method exclude first row and current column then construct a new matrix ,
     * without the excluded row and column.
     * The Laplace expansion is computationally inefficient for high dimension matrices.
     */
    private static int[][] buildMatrix(int[][] matrix , int removedColumn){
        int n = matrix.length;
        // create a matrix one dimension smaller than the last.
        int[][] newMatrix = new int[n -1][n - 1];
        int currentRow = 0; // to track the row of the new matrix
        for (int i = 1; i < n; ++i , ++currentRow) {
            int currentCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == removedColumn)continue;
                newMatrix[currentRow][currentCol++] = matrix[i][j];
            } // end of inner loop
        } // end of outer loop
        return newMatrix;
    } // end of buildMatrix.

    public static void main (String[] args) {
        int[][] mat1 = new int[][]{
                {1 , 3 , 5 , 9},
                {1 , 3 , 1 , 7},
                {4 , 3 , 9 , 7},
                {5 , 2 , 0 , 9},
        }; // det(mat1) = -376
        int[][] mat2 = new int[][]{
                {1 , 3 , 5 , 4},
                {2 , 3 , 1 , 3},
                {4 , 3 , 9 , 7},
                {5 , 2 , 6 , 9},
        }; // det(mat2) = -152
        int[][] mat3 = new int[][]{
                {4 , 7 , 2 , 3},
                {1 , 3 , 1 , 2},
                {2 , 5 , 3 , 4},
                {1 , 4 , 2 , 3},
        }; // det(mat3) = -3
        int[][] mat4 = new int[][]{
                {1 , 0 , 0 , 0 , 0 , 2},
                {0 , 1 , 0 , 0 , 2 , 0},
                {0 , 0 , 1 , 2 , 0 , 0},
                {0 , 0 , 2 , 1 , 0 , 0},
                {0 , 2 , 0 , 0 , 1 , 0},
                {2 , 0 , 0 , 0 , 0 , 1},
        }; // det(mat4) = -27
        int[][] mat5 = new int[][]{
                {1 , 1 , 9 , 3 , 1 , 2 , 3},
                {9 , 1 , 8 , 4 , 2 , 3 , 1},
                {3 , 2 , 7 , 2 , 9 , 5 , 5},
                {4 , 6 , 2 , 1 , 7 , 9 , 6},
                {5 , 3 , 1 , 3 , 1 , 5 , 3},
                {2 , 7 , 9 , 5 , 0 , 1 , 2},
                {2 , 1 , 3 , 8 , 9 , 1 , 4}
        }; // det(mat4) = -27
        int[][] mat6 = new int[][]{
                {1 , 2 , 4 , 8 , 6 , 3 , 4 , 8 , 0 , 2},
                {2 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 1},
                {5 , 2 , 3 , 4 , 8 , 9 , 1 , 9 , 8 , 3},
                {0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                {1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0},
                {1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                {1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                {1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                {1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                {1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0}
        }; // det(mat5) = -27
        System.out.println(det(mat1));
        System.out.println(det(mat2));
        System.out.println(det(mat3));
        System.out.println(det(mat4));
        System.out.println(det(mat5));
        System.out.println(det(mat6));
    }
}
