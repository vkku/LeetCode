package me.vkku.binarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ShippingCapacity_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Arrays.stream(weights).max().orElseThrow(() -> new RuntimeException("Array not valid"));
        int hi = Arrays.stream(weights).sum();
        int result = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, mid, days)) {
                result = Math.min(result, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int size, int ships) {
        int shipCap = 1;
        int shipsUsed = 0;
        for(int weight: weights){
            if(shipCap - weight < 0){
                shipsUsed++;
                shipCap = size;
            }
            shipCap -= weight;
        }
        return shipsUsed <= ships;
    }

    @Test
    public void driver(){
        ShippingCapacity_1011 shippingCapacity = new ShippingCapacity_1011();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shippingCapacity.shipWithinDays(weights, 5));
        System.out.println(shippingCapacity.canShip(weights, 14, 5));
    }


}
