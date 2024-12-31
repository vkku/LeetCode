package me.vkku.binarySearch;

import org.junit.jupiter.api.Test;
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumHigherOrLower_374 extends Guess {

    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        int mid = -1;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            int guessResult = guess(mid);
            if(guessResult == -1){
                hi = mid - 1;
            }else if(guessResult == 1){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return mid;
    }


}

class Guess{
    int pick = 0;
    @Test
    public void driver(){
        int num = 10;
        this.pick = 6;
        GuessNumHigherOrLower_374 guessNum = new GuessNumHigherOrLower_374();
        guessNum.pick = this.pick;
        System.out.printf("Num : %d, Pick : %d", num, pick);
        System.out.println();
        System.out.printf("Result : %d", guessNum.guessNumber(num)); //6
    }

    public int guess(int num){
        return guessInternal(num, pick);
    }

    public int guessInternal(int num, int pick){
        int result = 0;
        if(num < pick){
            result = 1;
        }else if(num > pick){
            result = -1;
        }
        return result;
    }
}