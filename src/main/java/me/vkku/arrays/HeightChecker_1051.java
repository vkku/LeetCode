package me.vkku.arrays;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

/*
https://leetcode.com/problems/height-checker/
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
Return the number of indices where heights[i] != expected[i].

Example:
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
 */
public class HeightChecker_1051 {

  @Test
  public int heightChecker(int[] arr) {
    int[] heightFreqArr = new int[101];
    int head = 0, count = 0;
    for(int i = 0 ; i < arr.length ; i++){
      heightFreqArr[arr[i]]++;
    }
    for(int i = 0 ; i <= 100 ; i++){
      if(heightFreqArr[i] != 0){
        while(heightFreqArr[i]-- > 0){
          if(arr[head++] != i){
            count++;
          }
        }
      }
    }
    return count;
  }

  @Test
  public int faster(int[] arr){
    int[] heightFreqArr = new int[101];
    int head = 0, count = 0;
    for(int i = 0 ; i < arr.length ; i++){
      heightFreqArr[arr[i]]++;
    }
    int curr = 0;
    for(int i = 0 ; i < arr.length ; i++){
      while(heightFreqArr[curr] == 0) curr++;
      if(curr != arr[i]) count++;
      heightFreqArr[curr]--;
    }
    return count;
  }

  @Test
  public void driver(){
    //int[] arr = {1,1,4,2,1,3};
    int[] arr = {5,1,2,3,4};
    faster(arr);
  }
}
