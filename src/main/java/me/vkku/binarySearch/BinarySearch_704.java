package me.vkku.binarySearch;

import org.junit.jupiter.api.Test;

public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while(lo <= hi){
            // (hi - lo) to avoid integer overflow
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void driver(){
        BinarySearch_704 binarySearch = new BinarySearch_704();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(binarySearch.search(nums, 9)); //4
        System.out.println(binarySearch.search(nums, 2)); //-1
    }
}
