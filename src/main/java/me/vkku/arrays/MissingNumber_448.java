package me.vkku.arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MissingNumber_448 {
  List<Integer> resultList = new ArrayList<>();
  public List<Integer> findDisappearedNumbers(int[] arr) {
    for(int i = 0 ; i < arr.length ; i++){
      int indexVal = Math.abs(arr[i]);
      if(arr[indexVal - 1] > 0){
        arr[indexVal - 1] = -arr[indexVal - 1];
      }
    }
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] > 0){
        resultList.add(i + 1);
      }
    }
    return resultList;
  }

  @Test
  public void driver(){
    int[] arr = {1,1,1,4};
    System.out.println(findDisappearedNumbers(arr));
  }
}
