package me.vkku.binarySearch;

import org.junit.jupiter.api.Test;

/*
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
    You must not use any built-in exponent function or operator.
    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

    Example:
    Input: x = 4
    Output: 2
    Explanation: The square root of 4 is 2, so we return 2.
 */
public class Sqrt_69 {
    public int mySqrt(int x) {
        int lo = 0;
        int hi = x/2;
        int mid = -1;
        int res = 0;
        while(lo <= hi){
            mid = lo + ((hi - lo) / 2);
            if ((long) mid * mid > (long) x) {
                hi = mid - 1;
            }else if(mid * mid == x){
                return mid;
            }else {
                lo = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    @Test
    public void driver(){
        Sqrt_69 sqrt = new Sqrt_69();
        System.out.println(sqrt.mySqrt(2147395599));
    }
}
