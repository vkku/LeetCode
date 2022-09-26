package me.vkku.arrays;

import org.junit.jupiter.api.Test;
/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/submissions/
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
After doing so, return the array.

Example:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation:
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
 */
public class ReplaceWithGreatestOnRight_1299 {

  @Test
  public int[] replaceElements(int[] arr) {
    int size = arr.length - 1, max = arr[size];
    for (int i = size; i >= 0; i--) {
      if (arr[i] > max) {
        int replaceMax = arr[i];
        arr[i] = max;
        max = replaceMax;
      } else {
        arr[i] = max;
      }
    }
    arr[size] = -1;
    return arr;
  }

  @Test
  public void driver() {
    int[] arr = {17, 18, 5, 4, 6, 1};
    replaceElements(arr);
  }


}
