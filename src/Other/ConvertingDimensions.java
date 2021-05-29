package Other;

/**
 * M[i][j]=M[n*i+j] , where n is the number of cols.
 * This is the one way of converting 2-d indices into one 1-d index.
 * M[i] => M[i/n][i%n] where n is the number of cols.
 */
public class ConvertingDimensions {

    public static int[] convertTo1d(int[][] mat){
        int r = mat.length , c = mat[0].length;
        int[] ans = new int[r * c];
        for (int i = 0 , len = r * c; i < len; ++i){
            ans[i] = mat[i / c][i % c]; // also ans[c * (i/c) + (i % c)] = mat[i / c][i % c];
        }
        return ans;
    }
    public static int[][] convertTo2d(int[] nums , int r , int c){
        if (r * c != nums.length){
            throw new IllegalArgumentException("dimensions are not valid");
        }
        int [][] mat = new int[r][c];
        for (int i = 0 , len = r * c; i < len; ++i){
            mat[i / c][i % c] = nums[i];
        }
        return mat;
    }

    public static void main (String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        var array = convertTo1d(matrix);
        var mat = convertTo2d(array , 3 ,3); // [1][9] , [9][1] , [3][3]
        for (int num : array){
            System.out.print(num + " ");
        }
        System.out.println();
        for (int[] ints : mat) {
            for (int anInt : ints)
                System.out.print(anInt + " ");
            System.out.println();
        }
    }
}
