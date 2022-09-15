package me.vkku.arrays;

import org.junit.jupiter.api.Test;

public class DuplicateZeros_1089 {

  /*
  Input: arr = [1,0,2,3,0,4,5,0]
  Output: [1,0,0,2,3,0,0,4]
  Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
  */
  @Test
  public void duplicateZeroes_N_Squared(int[] arr) {
    int left = 0, right = arr.length - 1;
    for (int i = 0; i < arr.length; i++) {
      left = i;
      if (arr[i] == 0) {
        while (right > left) {
          arr[right] = arr[right - 1];
          right--;
        }
        left = left + 2;
        i++;
        right = arr.length - 1;
      }
    }
  }

  @Test
  public void duplicateZeroes_N(int[] arr) {
    int length = arr.length - 1;
    int validZeroes = 0;
    for (int i = 0; i <= length - validZeroes; i++) {
      if (arr[i] == 0) {
        if (i == length - validZeroes) {
          arr[length] = 0;
          length--;
          break;
        }
        validZeroes++;
      }
    }
    int right = length;
    for (int i = right - validZeroes; i >= 0; i--) {
      if (arr[i] == 0) {
        arr[right] = 0;
        arr[right - 1] = 0;
        right -= 2;
      } else {
        arr[right] = arr[i];
        right--;
      }
    }

  }

  @Test
  public void testDupe() {
    //0,4,1,0,0,8,0,0,3
    /*
    Input
        [1,5,2,0,6,8,0,6,0]
    Output
        [1,1,5,2,0,0,6,8,0]
    Expected
        [1,5,2,0,0,6,8,0,0]

     */
    int[] intArr = {8, 4, 5, 0, 0, 0, 0, 7};
    duplicateZeroes_N(intArr);
  }

}
