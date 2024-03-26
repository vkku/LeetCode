package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    Intuition
    Duplicate elements can be marked and listed

    Approach
    A boolean array of size n+1 can raise flag if the value is previously encountered and add it to result if found true

    Complexity
    Time complexity:
    O(n)

    Space complexity:
    O(2n)
 */
public class AllDuplicates_442 {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] repeated = new boolean[nums.length + 1];
        int mod = (int) 1e5 + 1;
        for (int i = 0; i < nums.length; i++) {
            if (repeated[nums[i]]) {
                result.add(nums[i]);
            } else {
                repeated[nums[i]] = true;
            }
        }
        return result;
    }

    @Test
    public void driver() {
        System.out.println(findDuplicates(Arrays.stream(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).toArray()));
    }
}
