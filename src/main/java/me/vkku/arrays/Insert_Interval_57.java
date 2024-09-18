package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Insert_Interval_57 {
    List<int[]> result = new ArrayList<>();
    int count = 0;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length > 0 && intervals[0].length > 0) {
            int startIndex = 0;
            int endIndex = 0;
            boolean flag = false;
            for (int i = 0; i < intervals.length; i++) {
                startIndex = 0;
                endIndex = 0;
                int newIntervalStart = newInterval[0];
                int newIntervalEnd = newInterval[1];
                int currentIntervalStart = intervals[i][0];
                int currentIntervalEnd = intervals[i][1];
                for (int j = currentIntervalStart; j <= currentIntervalEnd; j++) {
                    if ((j >= newIntervalStart && j <= newIntervalEnd) || (newIntervalStart < currentIntervalStart && newIntervalEnd > currentIntervalStart)) {
                        flag = true;
                        startIndex = Math.min(intervals[i][0], newIntervalStart);
                        endIndex = Math.max(intervals[i][1], newIntervalEnd);
                    } else if(j == newIntervalStart){
                        flag = true;
                        startIndex = intervals[i][0];
                        endIndex = newIntervalEnd;
                    } else if(j == newIntervalEnd){
                        flag = true;
                        startIndex = newIntervalStart;
                        endIndex = intervals[i][1];
                    } else {
                        startIndex = currentIntervalStart;
                        endIndex = currentIntervalEnd;
                    }

                }

                //current interval is contained in previously stretched interval
                if (count > 0 && result.get(count - 1)[0] <= startIndex && result.get(count - 1)[1] >= endIndex) {
                    continue;
                }
                if (count > 0 && result.get(count - 1)[1] == startIndex) {
                    result.get(count - 1)[1] = endIndex;
                    continue;
                }
                int[] modifiedInterval = {startIndex, endIndex};
                if (!result.contains(modifiedInterval)) {
                    result.add(modifiedInterval);
                    count++;
                }
            }
            //if new interval is totally isolated (not touching or included)
            if(!flag && count > 0 && startIndex > newInterval[1]){
                result.add(newInterval);
            }else if(!flag && count > 0 && endIndex < newInterval[0]){
                result.add(newInterval);
            }
        }
        if(result.isEmpty()){
            result.add(newInterval);
        }
        return result.toArray(new int[0][]);
    }

    @Test
    public void driver(){
        Insert_Interval_57 ii = new Insert_Interval_57();
        int[][] expected = new int[][]{{1, 5}, {6, 9}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(ii.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));


        Insert_Interval_57 ij = new Insert_Interval_57();
        expected = new int[][]{{1, 2}, {3, 10}, {12, 16}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(ij.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8})));


        Insert_Interval_57 ik = new Insert_Interval_57();
        expected = new int[][]{{5, 7}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(ik.insert(new int[][]{{}}, new int[]{5, 7})));


        Insert_Interval_57 il = new Insert_Interval_57();
        expected = new int[][]{{1, 7}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(il.insert(new int[][]{{1, 5}}, new int[]{5, 7})));


        Insert_Interval_57 im = new Insert_Interval_57();
        expected = new int[][]{{1, 5}, {6, 8}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(im.insert(new int[][]{{1, 5}}, new int[]{6, 8})));


        Insert_Interval_57 in = new Insert_Interval_57();
        expected = new int[][]{{0, 5}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(in.insert(new int[][]{{1, 5}}, new int[]{0, 3})));

    }
}
