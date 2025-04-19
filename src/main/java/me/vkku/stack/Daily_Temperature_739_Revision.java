package me.vkku.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Daily_Temperature_739_Revision {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<List<Integer>> temperatureWithIndex = new Stack<>();
        for(int i = 0 ; i < temperatures.length ; i++) {
            while (!temperatureWithIndex.isEmpty() && temperatures[i] > temperatureWithIndex.peek().get(0)) {
                List<Integer> top = temperatureWithIndex.pop();
                int index = top.get(1);
                result[index] = i - index;
            }
            temperatureWithIndex.add(List.of(temperatures[i], i));
        }
        return result;
    }

    @Test
    public void driver() {
        Daily_Temperature_739_Revision dt = new Daily_Temperature_739_Revision();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));   //[1, 1, 4, 2, 1, 1, 0, 0]
    }
}
