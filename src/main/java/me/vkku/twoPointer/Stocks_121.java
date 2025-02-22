package me.vkku.twoPointer;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Stocks_121 {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        ArrayList<Integer> maxProfitArr = new ArrayList<>();
        maxProfitArr.add(0);
        while(right < prices.length && left < prices.length){
            if(prices[right] - prices[left] < 0){
                left++;
            }else{
                maxProfitArr.add(prices[right] - prices[left]);
                right++;
            }
        }
        return Collections.max(maxProfitArr);
    }

    @Test
    void driver(){
        Stocks_121 stocks = new Stocks_121();
//        System.out.println("Profit is : " + stocks.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Profit is : " + stocks.maxProfit(new int[]{1}));
    }
}
