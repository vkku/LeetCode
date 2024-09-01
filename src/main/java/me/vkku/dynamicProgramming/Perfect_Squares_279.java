package me.vkku.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Perfect_Squares_279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j * j <= i ; j++){
                int square = j * j;
                if(dp[i - square] < min){
                    min = dp[i - square];
                }
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    @Test
    public void driver(){
        Perfect_Squares_279 squares = new Perfect_Squares_279();
        System.out.println(squares.numSquares(7168));
    }
}
