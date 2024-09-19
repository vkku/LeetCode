package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    # Intuition
    <!-- Describe your first thoughts on how to solve this problem. -->
    Interval Problem pattern:
    Since it's sorted, simple cases first and rest follows(in else)
    1. Break problem into cases
    2. Consolidate the cases till minimal set is reached
    # Approach
    <!-- Describe your approach to solving the problem. -->
    Create a result list and iterate with intervals. Either add interval based on below scenarios or stretch interval.

    There can be multiple scenarios
    ![57.jpg](https://assets.leetcode.com/users/images/14212dae-01e7-4c5a-93c3-0f61eaa11186_1726730363.7825503.jpeg)

    But, these scenarios contain all :
    1. new interval happens before
    2. new interval happens after
    3. new interval happens anywhere else, in that case just keep stretching new interval and don't add it to result list inside loop
    # Complexity
    - Time complexity:
    <!-- Add your time complexity here, e.g. $$O(n)$$ -->
    O(n)
    - Space complexity:
    <!-- Add your space complexity here, e.g. $$O(n)$$ -->
    O(n)
 */

public class Insert_Interval_57 {
    List<int[]> result = new ArrayList<>();
    int count = 0;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length > 0 && intervals[0].length > 0){
            for(int i = 0 ; i < intervals.length ; i++){
                //Scenario 1 : new interval happens before current interval
                if(newInterval[1] < intervals[i][0]){
                    result.add(newInterval);
                    /*
                    for(int j = i ; j < intervals.length ; j++){
                        result.add(intervals[j]);
                    }
                    */
                    //Simplified version of above commented code
                    result.addAll(List.of(Arrays.copyOfRange(intervals, i, intervals.length)));
                    return result.toArray(new int[0][]);
                }

                //Scenario 2 : new interval happens after current interval
                else if(newInterval[0] > intervals[i][1]){
                    //Adding current interval only since there can be intervals ahead which will be merged into new interval
                    result.add(intervals[i]);
                }

                //Scenario 3 : new interval is anywhere eles viz. included in current interval(touching end/start or completely included), extend new interval in this scenario
                else{
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
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
