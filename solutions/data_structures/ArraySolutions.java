package solutions.data_structures;

import java.util.Arrays;

public class ArraySolutions {

    // # 1
    public static int maxIncreaseKeepingSkyline(final int[][] grid){

    //get max value of each row
        final int[] rowMaxes = new int[grid.length];
        int r_i = 0;
        for (final int[] elt : grid){
            rowMaxes[r_i++] = Arrays.stream(elt).max().getAsInt();
        }

        //get max value of each column
        final int[] colMaxes = new int[grid.length];

        //transpose the input array
        final int[][] transpose = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j =0; j < grid.length; j++){
                transpose[j][i] = grid[i][j];
            }
        }
        int z = 0;
        for (final int[] elt: transpose){
            colMaxes[z++] = Arrays.stream(elt).max().getAsInt();
        }


        int diffs = 0;
        for (int ii = 0; ii < grid.length; ii++){

            for (int jj = 0; jj < grid.length; jj++ ){
                final int current = grid[ii][jj];
                final int ceil = Math.min(rowMaxes[ii], colMaxes[jj]);
                final int diff = Math.max(ceil - current, 0);
                diffs += diff;
            }
        }
        return diffs;
    

    }
}
