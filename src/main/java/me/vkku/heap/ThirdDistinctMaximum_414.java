package me.vkku.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

/*
https://leetcode.com/problems/third-maximum-number/
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
  Example 1:
    Input: nums = [3,2,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2.
    The third distinct maximum is 1.

    Example 2:
    Input: nums = [1,2]
    Output: 2
    Explanation:
    The first distinct maximum is 2.
    The second distinct maximum is 1.
    The third distinct maximum does not exist, so the maximum (2) is returned instead.

    Example 3:
    Input: nums = [2,2,3,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2 (both 2's are counted together since they have the same value).
    The third distinct maximum is 1
*/
public class ThirdDistinctMaximum_414 {

  public int thirdMax(int[] arr) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    HashSet<Integer> elementSet = new HashSet<>();
    for(int i = 0 ; i < arr.length ; i++){
      if(elementSet.contains(arr[i])){
        continue;
      }
      else if(minHeap.size() == 3 && arr[i] > minHeap.peek()){
        elementSet.remove(minHeap.poll());
        elementSet.add(arr[i]);
        minHeap.add(arr[i]);
      }else if(minHeap.size() < 3){
        elementSet.add(arr[i]);
        minHeap.add(arr[i]);
      }
    }
    if(minHeap.size() == 3){
      return minHeap.poll();
    }
    else if(minHeap.size() == 2){
      int heapHead = minHeap.poll();
      return Math.max(heapHead, minHeap.poll());
    }
    return minHeap.poll();
  }

  @Test
  public void driver(){
    int[] arr = {5,2,4,1,3,6,0};
    System.out.println(thirdMax(arr));
  }
}
