package me.vkku.arrays;

import org.junit.jupiter.api.Test;

public class FindDuplicateFloyd_287 {
    public int findDuplicate(int[] nums) {
        //Find Intersection
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        //Find cycle's starting point
        int slowFront = 0;
        do {
            slowFront = nums[slowFront];
            slow = nums[slow];
        } while (slowFront != slow);
        return slow;
    }

    @Test
    public void driver() {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
