import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


class SubArraySort {
	/*
        given a partially sorted array
        find the start and end indices of the sub array that is out of order or -1 -1 if sorted already
        [1 2 3 10 3 4 2 13]  returns [2, 6]
    */
      public static int[] subarraySort(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        //store original index of each value in the array
        for (int i = 0; i < array.length; i++)
            map.put(i, array[i]);
        //sort the array
        Arrays.sort(array);
        //store the new index of each value
        Map<Integer, Integer> sorted = new HashMap<>();
        for (int i = 0; i < array.length; i++)
            sorted.put(i, array[i]);

        //compare different mappings, the minimum and most maximum differences are the solution
        Iterator<Entry<Integer, Integer>> iter = sorted.entrySet().iterator();
        //filter out any non-identical mapping entries and store
        List<Integer> diffs = map.entrySet().stream().
            filter(e -> !e.equals(iter.next())).
            map(e -> e.getKey()).
            collect(Collectors.toList());


        //first and last in the collection are returned
        return diffs.size() == 0 ? new int[]{-1,-1}: new int[]{diffs.get(0),diffs.get(diffs.size()-1)};
  }
}