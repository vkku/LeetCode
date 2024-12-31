package me.vkku.iw;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Runax {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findPairs(int[] nums, int target){
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int element : nums){
            if(numsSet.contains(target - element)){
                ArrayList<Integer> res = new ArrayList<>();
                res.add(element);
                res.add(target - element);
                numsSet.remove(element);
                result.add(res);
            }
        }
        return result;
    }

    @Test
    public void driver(){
        int[] arr = {1, 5, 7, -1};
        Runax runax = new Runax();
        System.out.println(runax.findPairs(arr, 6));
    }
}
