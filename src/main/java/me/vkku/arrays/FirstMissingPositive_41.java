package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        boolean[] firstMissing = new boolean[max + 1];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0)
                firstMissing[nums[i]] = true;
        }
        int j;
        int index = 0;
        boolean found = false;
        firstMissing[0] = true;
        for(j = 0 ; j < max ; j++){
            if(!firstMissing[j]){
                found = true;
                index = j;
                break;
            }
        }
        if(!found)
            j++;
        return j;
    }

    @Test
    public void driver(){
        System.out.println(firstMissingPositive(Arrays.stream(new int[]{1}).toArray()));
    }
}
