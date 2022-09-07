package me.vkku.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class SquaresSortedArray_977 {

  //Cherry on pie: Solve in O(n)

  @Test
  public int[] sortedSquares(int[] nums) {
    int arrSize = nums.length - 1;
    int left = 0;
    int resultsIndex = arrSize;
    int right = nums.length - 1;
    int[] resultArr = new int[arrSize + 1];
    for(int i = arrSize ; i >= 0 ; i--){
      int squaredRight = (int) Math.pow(nums[right], 2);
      int squaredLeft = (int) Math.pow(nums[left], 2);
      if(squaredLeft > squaredRight){
        resultArr[resultsIndex] = squaredLeft;
        left++;
      }
      else{
        resultArr[resultsIndex] = squaredRight;
        right--;
      }
      resultsIndex--;
    }
    Arrays.parallelSort(resultArr);
    return resultArr;
  }

  @Test
  public void validate(){
    int[] intArr = {-7,-3,2,3,11};
    System.out.println(sortedSquares(intArr));
  }

}
