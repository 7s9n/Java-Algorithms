package LeetCode;

/**
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one
 * with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c
 * representing the row number and column number of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing
 * order as they were.
 * If the reshape operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix {
    public static void main (String[] args) {
        int[][] mat = new int[][]
                {
                        {1,2,3},
                        {4,5,6}
                };
        mat = matrixReshape(mat,0,0);
        for (var array : mat){
            for (var num : array){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length)return mat;

        int[][] ans = new int[r][c];
        for(int i = 0 , length = r * c; i < length ; ++ i)
            ans[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length];
        return ans;
    }
}
