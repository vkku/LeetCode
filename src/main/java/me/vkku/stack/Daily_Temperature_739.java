package me.vkku.stack;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Daily_Temperature_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<List<Integer>> temperatureStack = new Stack<>();
        temperatureStack.push(List.of(temperatures[0], 0));
        for (int i = 1; i < temperatures.length; i++) {
            while (!temperatureStack.isEmpty() && temperatures[i] > temperatureStack.peek().get(0)) {
                result[temperatureStack.peek().get(1)] = i - temperatureStack.peek().get(1);
                temperatureStack.pop();
            }
            temperatureStack.push(List.of(temperatures[i], i));
        }
        return result;
    }

    @Test
    public void driver() {
        Daily_Temperature_739 dt = new Daily_Temperature_739();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
