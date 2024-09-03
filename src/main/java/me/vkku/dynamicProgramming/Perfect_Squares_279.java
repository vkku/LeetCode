package me.vkku.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    Intuition
    Since lot of repetition involved, DP would be a nice strategy

    Approach
    Use your past to go in future ;-)
    For each dp index, check by subtracting each perfect square starting from 1 to see which has least stored value,
    add 1 afterwards since 1 more square is done in inner loop(j * j)

    Complexity
    Time complexity:
    O(n.n^1/2)

    Space complexity:
    O(n)
 */

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

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; (j * j) <= i ; j++){
                int square = j * j;
                if(dp[i - square] < min){
                    min = dp[i - square];
                }
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}