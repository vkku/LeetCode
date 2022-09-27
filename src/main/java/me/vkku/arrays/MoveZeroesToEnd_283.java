package me.vkku.arrays;

import org.junit.jupiter.api.Test;

public class MoveZeroesToEnd_283 {

  @Test
  public void moveZeroes(int[] arr) {
    int zeroPointer = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[zeroPointer++] = arr[i];
      }
    }
    for (int i = zeroPointer; i < arr.length; i++) {
      arr[i] = 0;
    }
  }

  @Test
  public void fastest(int[] arr) {
    int zeroPointer = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        int temp = arr[zeroPointer];
        arr[zeroPointer++] = arr[i];
        arr[i] = temp;
      }
    }
  }

  @Test
  public void driver() {
    int[] arr = {0, 1, 0, 3, 12};
    //int[] arr = {0, 0, 4, 0, 0, 4};
    fastest(arr);
  }

}
