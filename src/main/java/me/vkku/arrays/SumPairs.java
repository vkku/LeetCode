package me.vkku.arrays;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
/*
Find pairs matching the given sum in array
e.x. arr = 1, 5, 7, -1
sum = 6
result = 2 [(5, 1), (7, -1)]
 */
public class SumPairs {

  @Test
  public void findPairs(){
    System.out.println("Sum Pairs : " + extracted());
  }

  private static int extracted() {
    int[] arr = {1, 5, 7, -1};
    int k = 6;
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if(map.containsKey(k - arr[i])){
        count += map.get(k - arr[i]);
      }
      if(map.containsKey(arr[i])){
        map.put(arr[i], map.get(arr[i]+1));
      }
      else{
        map.put(arr[i], 1);
      }
    }
    return count;
  }

}
