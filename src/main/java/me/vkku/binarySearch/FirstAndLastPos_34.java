package me.vkku.binarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
/*
    # Intuition
    <!-- Describe your first thoughts on how to solve this problem. -->
    Linear search - but it'd result in linear time complexity, hence improvisation on binary search can get the job done
    # Approach
    <!-- Describe your approach to solving the problem. -->
    Binary search continued beyond target finding can be helpful.
    Binary search has to be run twice
    1. Once to find rightmost repeatedly occurring element, keep adjusting low even after target is found
    2. Again to find leftmost repeatedly occurring element, keep changing high pointer even after finding target element
    # Complexity
    - Time complexity:
    <!-- Add your time complexity here, e.g. $$O(n)$$ -->
    2 * log n = O(log n)
    - Space complexity:
    <!-- Add your space complexity here, e.g. $$O(n)$$ -->
    O(n)
 */
public class FirstAndLastPos_34 {
    public int[] searchRange(int[] nums, int target) {
        int start, end = 0;
        start = binarySearch(nums, target, false);
        end = binarySearch(nums, target, true);
        return new int[]{start, end};
    }

    public int binarySearch(int[] nums, int target, boolean rightBias){
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        int savePosition = -1;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                savePosition = mid;
                if(rightBias){
                    lo = mid + 1;
                }else {
                    hi = mid - 1;
                }
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return savePosition;
    }

    @Test
    public void driver(){
        int[] nums = {5,7,7,8,8,10};
        FirstAndLastPos_34 firstAndLastPos = new FirstAndLastPos_34();
        System.out.println(Arrays.toString(firstAndLastPos.searchRange(nums, 8))); //[3, 4]
        System.out.println(Arrays.toString(firstAndLastPos.searchRange(nums, 6))); //[-1, -1]
        System.out.println(Arrays.toString(firstAndLastPos.searchRange(new int[]{}, 0))); //[-1, -1]

    }
}
