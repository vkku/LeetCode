package me.vkku.binarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KokoBananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = Arrays.stream(piles).max().orElseThrow(() -> new RuntimeException("Array not valid"));
        int result = hi;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int timeRequired = timeTakenToFinishBananas(piles, mid);
            if(timeRequired > h){
                lo = mid + 1;
            } else if (timeRequired <= h) {
                result = Math.min(result, mid);
                hi = mid - 1;
            }
        }
        return result;
    }

    public int timeTakenToFinishBananas(int[] piles, int rate){
        int result = 0;
        for(int i = 0 ; i < piles.length ; i++){
            result +=  Math.ceil((double) piles[i] / (double) rate);
        }
        return result;
    }


    @Test
    public void driver(){
        KokoBananas_875 koko = new KokoBananas_875();
        int[] num = {30,11,23,4,20};
        System.out.println(koko.minEatingSpeed(num, 5));
    }
}
