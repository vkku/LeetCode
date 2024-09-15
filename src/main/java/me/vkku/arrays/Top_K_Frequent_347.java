package me.vkku.arrays;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    # Intuition
    <!-- Describe your first thoughts on how to solve this problem. -->
     Since this is a problem where we need to remember more than one of previous value to find repetition of an element, ruling out set.
     Max heap(k log n) can be used to solve this problem but with bucket sort, demostrating optimisation, we reduce complexity to O(n).

    # Approach
    <!-- Describe your approach to solving the problem. -->
    Create a histogram i.e. frequency map then create another Map<Integer, List<Integer>> with
    Key : value of frequency map
    Value : add to list the key of frequency map
    Iterate from end till the result array contains adequate elements(k).
    Example
    Input ->  [1, 1, 1, 2, 2, 3]
    Frequency Map -> [<1, 3> <2, 2> <3, 1>]
    Bucket Sort Map -> [<1, [3]> <2, [2]> <3, [1]>]

    How to read bucket sort map :
    starting from end : 1 appears 3 times, 2 appears 2 times, 3 appears 1 time
    That means if K is 2, most appearing numbers occurs 3 and 2 times which are values of element 3 & 2 i.e. 1 & 2.
    So, result = [1, 2]


    # Complexity
    - Time complexity:
    <!-- Add your time complexity here, e.g. $$O(n)$$ -->
    O(n)
    - Space complexity:
    <!-- Add your space complexity here, e.g. $$O(n)$$ -->
    O(n + n) = O(n)
 */

public class Top_K_Frequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, List<Integer>> bucketSort = new HashMap<>();
        int[] result = new int[k];
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
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

        int resultElementCount = 0;
        for(int elem : add){
            if(resultElementCount < k){
                result[resultElementCount++] = elem;
            }
        }


        return result;
    }

    @Test
    public void driver(){
        Top_K_Frequent_347 tkf = new Top_K_Frequent_347();
        System.out.println(Arrays.toString(tkf.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(tkf.topKFrequent(new int[]{1}, 1)));
    }
}
