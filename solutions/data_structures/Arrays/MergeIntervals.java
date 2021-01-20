import java.util.LinkedList;
import java.util.Arrays;

class MergeIntervals{



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