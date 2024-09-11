package me.vkku.stack;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Daily_Temperature_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> temperatureStack = new Stack<>();
        List<Integer> temperatureList = Arrays.stream(temperatures).boxed().collect(Collectors.toList());
//        Map<Integer, Integer> temperatureMap = prepareTempHashMap(temperatureList);
        temperatureStack.push(temperatures[0]);
        for(int i = 1 ; i < temperatures.length ; i++){
            int save = i - 1;
            while(!temperatureStack.empty()){
                if(temperatures[i] > temperatureStack.peek()){
                    result[save] = i - save;
                    temperatureStack.pop();
                }
            }
            temperatureStack.push(temperatures[i]);
        }
        return result;
    }

    private static Map<Integer, Integer> prepareTempHashMap(List<Integer> temperatureList) {
        Map<Integer, Integer> temperatureMap = new HashMap<>();
//        IntStream.of(0, temperatureList.size() - 1)
//                .forEach(index -> {
//                    temperatureMap.put(temperatureList.get(index), index);
//                });
        for(int i = 0 ; i < temperatureList.size() ; i++){
            temperatureMap.put(temperatureList.get(i), i);
        }
        return temperatureMap;
    }

    @Test
    public void driver(){
        Daily_Temperature_739 dt = new Daily_Temperature_739();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
