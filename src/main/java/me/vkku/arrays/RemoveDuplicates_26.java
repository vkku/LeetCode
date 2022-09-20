package me.vkku.arrays;

import org.junit.jupiter.api.Test;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages,
you must instead have the result be placed in the first part of the array nums.
More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */

public class RemoveDuplicates_26 {

  @Test
  public int removeDuplicates(int[] nums) {
    boolean makeCompression = false;
    int i = 0;
    for(int j = 1 ; j < nums.length ; j++){
      if(nums[i] != nums[j] && makeCompression){
        nums[i + 1] = nums[j];
        i++;
      }else if(nums[i] == nums[j]){
        makeCompression = true;
      }else{
        i++;
      }
    }
    return i + 1;
  }

  @Test
  public int cleanApproach(int[] nums){
    int insertionPosition = 1;
    for(int j = 1 ; j < nums.length ; j++){
      if(nums[j -1] != nums[j]){
        nums[insertionPosition] = nums[j];
        insertionPosition++;
      }
    }
    return insertionPosition + 1;
  }

  @Test
  public int fastestFingersFirst(int[] nums){
    int fittingPosition = 1, current = nums[0], count = 1, size = nums.length;
    for(int j = 1 ; j < size ; j++){
      if(nums[j] ==  current){
        continue;
      }
      else{
        current = nums[j];
        nums[fittingPosition++] = current;
        count++;
      }
    }
    return count;
  }

  @Test
  public int fastest(int[] nums){
    int slow = 1, size = nums.length;
    for(int fast = 1 ; fast < size ; fast++){
      if(nums[fast - 1] != nums[fast]){
        nums[slow++] = nums[fast];
      }
    }
    return slow;
  }

  @Test
  public void driver(){
    int[] nums = {0,0,1,1,1,2,2,3,3,4};
    fastest(nums);
  }

}
