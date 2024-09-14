package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Top_K_Frequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, List<Integer>> bucketSort = new HashMap<>();
        int[] result = new int[k];
        for (int num : nums) {
            frequencyMap.putIfAbsent(num, 0);
            frequencyMap.put(num, frequencyMap.get(num) + 1);
        }
        for(Integer index : frequencyMap.keySet()){
            List<Integer> currentList = bucketSort.getOrDefault(frequencyMap.get(index), new ArrayList<>());
            currentList.add(index);
            bucketSort.put(frequencyMap.get(index), currentList);
        }

        List<Integer> add = new ArrayList<>();
        bucketSort.keySet().stream().sorted(Comparator.reverseOrder()).forEach(key -> {
            add.addAll(bucketSort.get(key));
        });

        int o = 0;
        for(int elem : add){
            if(o < k){
                result[o++] = elem;
            }
        }


        return result;
    }

    @Test
    public void driver(){
        Top_K_Frequent_347 tkf = new Top_K_Frequent_347();
        System.out.println(Arrays.toString(tkf.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
