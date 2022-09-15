package me.vkku.arrays;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MergeSortedArray_88 {

  /*
  https://leetcode.com/problems/merge-sorted-array/
  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
  Output: [1,2,2,3,5,6]
  Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
  The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
   */

  @Test
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int length = m + n - 1, ptr1 = m - 1, ptr2 = n - 1;
    while(ptr1 >= 0 && ptr2 >= 0){
      nums1[length--] = nums1[ptr1] > nums2[ptr2] ? nums1[ptr1--] : nums2[ptr2--];
    }
    while (ptr2 >= 0){
      nums1[length--] = nums2[ptr2--];
    }
  }

  /* Faster Code
    int length = m + n - 1, ptr1 = m-1, ptr2 = n-1;
    while (length >= 0){
      if(ptr2 == -1)
        return;
      if(ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]){
        nums1[length--] = nums1[ptr1--];
      }else{
        nums1[length--] = nums2[ptr2--];
      }
    }
   */

  @Test
  public void driver() {
    int[] nums1 = {0};
    int[] nums2 = {1};
    int m = 0, n = 1;
    merge(nums1, m, nums2, n);
  }

}
