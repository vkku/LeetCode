//package me.vkku.binarySearch;
//
//import java.util.Arrays;
//
//public class ShippingCapacity_1011 {
//    public int shipWithinDays(int[] weights, int days) {
//        int lo = Arrays.stream(weights).max().orElseThrow(() -> new RuntimeException("Array not valid"));
//        int hi = Arrays.stream(weights).sum();
//        int result = hi;
//        while(lo <= hi){
//            int mid = lo + (hi - lo) / 2;
//            if(canShip)
//                if(timeRequired > days){
//                    lo = mid + 1;
//                } else if (timeRequired <= days) {
//                    result = Math.min(result, mid);
//                    hi = mid - 1;
//                }
//        }
//        return result;
//    }
//}
