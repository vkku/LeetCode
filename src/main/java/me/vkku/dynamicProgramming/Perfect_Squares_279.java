package me.vkku.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Perfect_Squares_279 {
    public int numSquares(int n) {
        int[] dp = new int[n * (n+1)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= i + 1 ; j++){
                int square = j * j;
                if((i - square) < 0){
                    break;
                }
                int min = Math.min(dp[i], 1 + dp[i - square]);
                if((1 + dp[i - square]) < dp[i]){
                    dp[i] = 1 + dp[i - square];
                }
            }
        }
        return dp[n];
    }

    @Test
    public void driver(){
        Perfect_Squares_279 squares = new Perfect_Squares_279();
        System.out.println(squares.numSquares(7168));
    }
}
