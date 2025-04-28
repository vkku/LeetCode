package me.vkku.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Daily_Temperature_739_Revision {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<List<Integer>> temperatureIndexedStack = new Stack<>();
        int[] result =  new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length ; i++){
            while(!temperatureIndexedStack.isEmpty() && temperatures[i] > temperatureIndexedStack.peek().get(0)){
                var element = temperatureIndexedStack.pop();
                Integer index = element.get(1);
                result[index] = i - index;
            }
            temperatureIndexedStack.add(List.of(temperatures[i], i));
        }
        return result;
    }

    @Test
    public void driver() {
        Daily_Temperature_739_Revision dt = new Daily_Temperature_739_Revision();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));   //[1, 1, 4, 2, 1, 1, 0, 0]
    }
}
