package solutions.data_structures;

import java.util.Arrays;
import java.util.LinkedList;

public class ArraySolutions {

    // # 1
    public static int maxIncreaseKeepingSkyline(int[][] grid){

        //get max value of each row
        int[] rowMaxes = new int[grid.length];
        int r_i = 0;
        for (int[] elt : grid){
            rowMaxes[r_i++] = Arrays.stream(elt).max().getAsInt();
        }
        
         int[] colMaxes = new int[grid.length];
         int z = 0;
        //transpose the input array
        int[][] transpose = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j =0; j < grid.length; j++){
                transpose[j][i] = grid[i][j];
            }
        }
        //get max value of each column
        for ( int[] elt: transpose){
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

    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        LinkedList<int[]> result = new LinkedList<>();
        //first interval to compare all subsequent against (working interval)
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            //working interval
            int[] interval = result.peek();
            //current candidate interval
            int[] current = intervals[i];
            //merge if current candidate start time is before end of working interval
            if(current[0] <= interval[1]){
                //ensure working interval's end is larger than current candidate interval
                interval[1] = Math.max(current[1], interval[1]);
                //replace interval in case it has been mutated
                result.pop();
                result.push(interval);
            }else{
                //couldn't merge interval, current candidate will be working interval for subsequent checks
                result.push(current);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
