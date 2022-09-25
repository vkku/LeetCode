package me.vkku.arrays;

import org.junit.jupiter.api.Test;
/*
https://leetcode.com/problems/valid-mountain-array/
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */
public class ValidMountainArray_941 {

  @Test
  public boolean validMountainArray(int[] arr) {
    int i = 0;
    boolean decrementStarted = false;
    if (arr.length == 1) {
      return false;
    }
    if (arr[i + 1] < arr[i]) {
      return false;
    }
    for (i = 0; i < arr.length - 1; i++) {
      if (arr[i + 1] == arr[i]) {
        return false;
      } else if (arr[i + 1] < arr[i]) {
        decrementStarted = true;
      } else if (arr[i + 1] > arr[i] && decrementStarted) {
        return false;
      }
    }
    return decrementStarted;
  }

  @Test
  public boolean cleanCode(int[] arr) {
    //I remember thoughtworks
    int i = 0, size = arr.length;
    while (i + 1 < size && arr[i + 1] > arr[i]) {
      i++;
    }
    if (i == 0 || i == size - 1) {
      return false;
    }
    while (i + 1 < size && arr[i + 1] < arr[i]) {
      i++;
    }
    return i == size - 1;
  }

  @Test
  public boolean bestRatedSolution(int[] arr){
    int i = 0, j = arr.length-1;
    while(i+1 < arr.length && arr[i] < arr[i+1]){
      i++;
    }
    while(j-1 > 0 && arr[j-1] > arr[j]){
      j--;
    }
    //Only 1 element
    //Valid Case - Mountain Array
    //Only Increasing Array
    return i > 0 && i == j && j < arr.length-1;
  }

  @Test
  public void driver() {
    //int[] arr = {3,5,5};
    //int[] arr = {0,3,2,1};
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    bestRatedSolution(arr);
  }

}
