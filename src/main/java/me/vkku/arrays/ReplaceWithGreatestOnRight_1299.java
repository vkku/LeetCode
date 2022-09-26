package me.vkku.arrays;

import org.junit.jupiter.api.Test;

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
