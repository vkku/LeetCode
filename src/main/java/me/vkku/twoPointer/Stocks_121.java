package me.vkku.twoPointer;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Stocks_121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyRate = prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] < buyRate){
                buyRate = prices[i];
            }else{
                profit = Math.max(profit, prices[i] - buyRate);
            }
        }
        return profit;
    }

    @Test
    void driver(){
        Stocks_121 stocks = new Stocks_121();
        System.out.println("Profit is : " + stocks.maxProfit(new int[]{7,1,5,3,6,4})); //5
        System.out.println("Profit is : " + stocks.maxProfit(new int[]{1})); //0
        System.out.println("Profit is : " + stocks.maxProfit(new int[]{1, 2})); //1
    }
}
