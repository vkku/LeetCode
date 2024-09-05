package me.vkku.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    @Test
    public void driver(){
        Longest_Increasing_Subsequence_300 lis = new Longest_Increasing_Subsequence_300();
        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
