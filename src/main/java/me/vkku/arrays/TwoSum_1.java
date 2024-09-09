package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Solution :
    While we are iterating and inserting elements into the hash table, we also look back to check
    if current element's complement already exists in the hash table.
    If it exists, we have found a solution and return the indices immediately.
 */

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey((target - nums[i]))){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return result;
    }

    @Test
    public void driver(){
        int[] nums = {2,7,11,15};
        TwoSum_1 ts = new TwoSum_1();
        System.out.println(Arrays.toString(ts.twoSum(nums, 9)));
    }
}
