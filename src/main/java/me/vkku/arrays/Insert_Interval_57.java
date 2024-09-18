package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Insert_Interval_57 {
    List<int[]> result = new ArrayList<>();
    int count = 0;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length > 0 && intervals[0].length > 0){
            for(int i = 0 ; i < intervals.length ; i++){
                if(newInterval[1] < intervals[i][0]){
                    result.add(newInterval);
                    for(int j = i ; j < intervals.length ; j++){
                        result.add(intervals[j]);
                    }
                    return result.toArray(new int[0][]);
                }else if(newInterval[0] > intervals[i][1]){
                    result.add(intervals[i]);
                }else{
                    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                }
            }
        }
        result.add(newInterval);
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
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(ik.insert(new int[][]{}, new int[]{5, 7})));


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
