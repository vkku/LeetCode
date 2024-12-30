package me.vkku.binarySearch;
/*
    # Intuition
    <!-- Describe your first thoughts on how to solve this problem. -->
    Binary search can help match complexity
    # Approach
    <!-- Describe your approach to solving the problem. -->
    Binary search
    Binary search pointers(high, low, mid) rest in following fashion on completion, assuming ascendingly sorted array
    1. When element is at rightmost(array.length) - all pointers point to same index,
    also if element is not there and target is greater the low pointer further moves after mid, represented as :
    ```
    Array = {1, 3, 5, 7, 9} Target = 10

    Index:    0    1    2    3    4    5
    Array:   [1]  [3]  [5]  [7]  [9]  [ ]
                                  ^    ^
                                 hi    lo
                                  ^
                                 mid

    ```
    2. Same goes for leftmost, and if target is lesser than array[0] the high pointer moves further back, represented as :
    ```
    Array = {1, 3, 5, 7, 9} Target = 0

    Index:   -1    0    1    2    3    4    5
    Array:         [1]  [3]  [5]  [7]  [9]
            ^       ^
           hi      lo
                    ^
                   mid

    ```
    Given this setting, low pointer always points at the insertion position if the element is not included in array.
    # Complexity
    - Time complexity:
    <!-- Add your time complexity here, e.g. $$O(n)$$ -->
    O(log n)
    - Space complexity:
    <!-- Add your space complexity here, e.g. $$O(n)$$ -->
    O(n)
 */
public class SearchInsertPos_35 {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
