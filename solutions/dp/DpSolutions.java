package solutions.dp;
import java.util.Arrays;

public class DpSolutions {

    // # 1
    public int minFallingPathSum(int[][] A) {
        int[][] cache = new int[A.length][A.length];
        for (int[] r : cache)
            Arrays.fill(r, Integer.MAX_VALUE);
        int min = cache[0][0];
        for (int i = 0; i < A.length; i++){
            cache[0][i] = fallRecur(A, 0, i, cache);
            min = Math.min(cache[0][i], min);
        }
        return min;
    }

    //helper function for #1
    public static int fallRecur(int[][] A, int row, int col, int[][] cache){
        if (col < 0 || col > A.length-1) 
            return Integer.MAX_VALUE;
        if (cache[row][col] != Integer.MAX_VALUE) 
            return cache[row][col];
        if (row == A.length-1) 
            return A[row][col];
        int left = fallRecur(A, row+1, col-1, cache);
        int right = fallRecur(A, row+1, col+1, cache);
        int center = fallRecur(A, row+1, col, cache);
        cache[row][col] = A[row][col] +  Math.min(center, Math.min(left,right));
        return cache[row][col];
    }
    
}
