package LinearAlgebra;

import java.util.Arrays;

/**
 * In linear algebra, the transpose of a matrix is an operator which flips a matrix over its diagonal;
 * that is, it switches the row and column indices of the matrix A by producing another matrix.
 * The transpose of a matrix was introduced in 1858 by the British mathematician Arthur Cayley.
 */
public class TransposeMatrix {
    public static int[][] transpose(int[][] mat){
        if (mat == null)
            return null;
        // r is the number of rows of the matrix {mat}.
        // c is the number of columns of the matrix {mat}.
        int r = mat.length , c = mat[0].length;
        int[][] newMatrix = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                newMatrix[j][i] = mat[i][j];
        }
        return newMatrix;
    }
    public static void transposeInPlace(int[][] mat){
        if (mat == null)
            return;
        // r is the number of rows of the matrix {mat}.
        // c is the number of columns of the matrix {mat}.
        int r = mat.length , c = mat[0].length;
        if (r != c)
            return;

        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++){
                int tmp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = tmp;
            }
        }
    }

    public static void main (String[] args) {
        int[][] mat = new int[][]{
            {1,2,3}
        };
        int[][] mat2 = new int[][]{
                {1 , 2 , 3},
                {4 , 5 , 6}
        };
        int[][] mat3 = new int[][]{
                {1 , 2 , 3} ,
                {4 , 5 , 6} ,
                {7 , 8 , 9}
        };
        for (int[] row : transpose(mat))
            System.out.println(Arrays.toString(row));
        for (int[] row : transpose(mat2))
            System.out.println(Arrays.toString(row));

        transposeInPlace(mat3);
        for (int[] row : mat3)
            System.out.println(Arrays.toString(row));
    }
}
