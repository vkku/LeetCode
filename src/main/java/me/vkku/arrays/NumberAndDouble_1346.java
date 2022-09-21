package me.vkku.arrays;

import com.sun.tools.javac.util.ArrayUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import sun.security.util.ArrayUtil;

public class NumberAndDouble_1346 {

  @Test
  public boolean checkIfExist(int[] arr) {
    HashMap<Object, Object> indexDoubleMap = new HashMap<>();
    int zeroCount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        zeroCount++;
        continue;
      }
      indexDoubleMap.put(arr[i], arr[i] * 2);
    }
    if (zeroCount >= 2) {
      return true;
    } else {
      return indexDoubleMap.keySet().stream().anyMatch(indexDoubleMap::containsValue);
    }
  }

  @Test
  public boolean faster(int[] nums) {
    HashSet<Object> arrSet = new HashSet<>();
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (arrSet.contains(nums[i] * 2) || (arrSet.contains(nums[i] / 2) && nums[i] % 2 == 0)) {
        return true;
      }
      arrSet.add(nums[i]);
    }
    return false;
  }

  @Test
  public void driver() {
    //int[] nums = {-2,0,10,-19,4,6,-8};
    int[] nums = {-20, 8, -6, -14, 0, -19, 14, 4};
    faster(nums);
  }

}
