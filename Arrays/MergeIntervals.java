package DSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        List<int[]> output_arr = new ArrayList<>();
        int[] current_interval = intervals[0];
        output_arr.add(current_interval);

        for ( int[] interval : intervals){
            int current_start = current_interval[0];
            int current_end = current_interval[1];
            int next_start = interval[0];
            int next_end = interval[1];

            if(current_end >= next_start){
                current_interval[1] = Math.max(current_end, next_end);
            }

            else{
                current_interval = interval;
                output_arr.add(interval);
            }

        }
        return output_arr.toArray(new int[output_arr.size()][]);
    }
}

// check how many elements in 2d Array if <= 1 return array
// sort array using Arrays.sort(interval, (a,b) -> Integer.compare(a[0],b[0]);
// then create a list of array because we are working with 2D array and we dont have fixed size for array
// then copy first element and mark it as current_interval
// mark star and end for current and mark start and end for next
// keep comparing and adding in the output arrray
// dont forget to convert arraylist to array as retunr type is int[][]