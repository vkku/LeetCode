package me.vkku.arrays;

import org.junit.jupiter.api.Test;
/*
https://leetcode.com/problems/sort-array-by-parity/
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]
 */
public class SortByParity_905 {

  @Test
  public int[] sortArrayByParity(int[] arr) {
    int evenPos = 0;
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] % 2 == 0){
        evenPos = swap(arr, evenPos, i);
      }
    }
    return arr;
  }

  private int swap(int[] arr, int evenPos, int i) {
    int temp = arr[evenPos];
    arr[evenPos++] = arr[i];
    arr[i] = temp;
    return evenPos;
  }

  @Test
  public void driver(){
    int[] arr = {3,1,2,4};
    sortArrayByParity(arr);
  }
}
