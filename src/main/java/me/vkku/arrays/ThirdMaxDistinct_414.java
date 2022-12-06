package me.vkku.arrays;

import org.junit.jupiter.api.Test;

public class ThirdMaxDistinct_414 {

  @Test
  public int thirdMax(int[] arr) {
    int max1 = 0, max2 = 0, max3 = 0;
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] > max1){
        max1 = arr[i];
      }
    }
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] > max2){
        if(arr[i] == max1)
          break;
        max2 = arr[i];
      }
    }
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] > max3){
        if(arr[i] == max2)
          break;
        max3 = arr[i];
      }
    }
    return max3;
  }

  @Test
  public void driver(){
    int[] arr = {3, 2, 1};
    //int[] arr = {1, 2};
    thirdMax(arr);
  }

}
