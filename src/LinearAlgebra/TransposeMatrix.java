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

    /**
     * In-place matrix transposition, also called in-situ matrix transposition,
     * is the problem of transposing an N×M matrix in-place in computer memory, ideally with O(1) (bounded) additional storage,
     * or at most with additional storage much less than NM. Typically,
     * the matrix is assumed to be stored in row-major order or column-major order
     * (i.e., contiguous rows or columns, respectively, arranged consecutively).
     * Performing an in-place transpose (in-situ transpose) is most difficult when N ≠ M, i.e.
     * for a non-square (rectangular) matrix, where it involves a complicated permutation of the data elements,
     * with many cycles of length greater than 2. In contrast, for a square matrix (N = M), all of the cycles are of length 1 or 2,
     * and the transpose can be achieved by a simple loop to swap the upper triangle of the matrix with the lower triangle.
     * Further complications arise if one wishes to maximize memory locality in order
     * to improve cache line utilization or to operate out-of-core (where the matrix does not fit into main memory),
     * since transposes inherently involve non-consecutive memory accesses.
     *
     * The problem of non-square in-place transposition has been studied since at least the late 1950s,
     * and several algorithms are known, including several which attempt to optimize locality for cache,
     * out-of-core, or similar memory-related contexts.
     */
    public static void transposeInPlace(int[][] mat){
        if (mat == null)
            return;
        // r is the number of rows of the matrix {mat}.
        // c is the number of columns of the matrix {mat}.
        int r = mat.length , c = mat[0].length;
        if (r != c)
            return;
        //For a square N×N matrix An,m = A(n,m),
        // in-place transposition is easy ,
        // because all of the cycles have length 1 (the diagonals An,n) or length 2 (the upper triangle is swapped with the lower triangle)
        for (int i = 0; i <= r - 2; i++) {
            for (int j = i + 1; j <= c - 1; j++)
                swap(mat , i , j);
        }
    }
    private static void swap(int[][] mat , int i , int j){
        int tmp = mat[j][i];
        mat[j][i] = mat[i][j];
        mat[i][j] = tmp;
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

        for (int[] row : transpose(mat3))
            System.out.println(Arrays.toString(row));

        transposeInPlace(mat3);
        for (int[] row : mat3)
            System.out.println(Arrays.toString(row));

    }
}
