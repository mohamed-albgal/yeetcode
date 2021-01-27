class Solution {
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length;i++){
            map.put(intervals[i][0],i);
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int[] res = new int[intervals.length];
        Arrays.fill(res,-1);
        for (int i = 0; i < intervals.length; i++){
            int[] inter = intervals[i];
            int thisStart = inter[0];
            int thisEnd  = inter[1];
            int index = map.get(thisStart);
            for (int j = i; j < intervals.length; j++){
                int[] nextInterval = intervals[j];
                if (nextInterval[0] >= thisEnd){
                    res[index] = map.get(nextInterval[0]);
                    break;
                }
            }
        }
        return res;
    }
}