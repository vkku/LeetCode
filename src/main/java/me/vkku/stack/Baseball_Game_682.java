package me.vkku.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.Stream;

public class Baseball_Game_682 {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        Stream.of(operations).forEach(operation -> {
            switch (operation){
                case "+" -> scores.add(scores.peek() + scores.get(scores.size() - 2));
                case "D" -> scores.add(scores.peek() * 2);
                case "C" -> scores.pop();
                default -> scores.add(Integer.parseInt(operation));
            }
        });

        return scores.stream().mapToInt(Integer::valueOf).sum();
    }

    @Test
    public void driver(){
        Baseball_Game_682 bg =  new Baseball_Game_682();
        System.out.println(bg.calPoints(new String[]{"5","2","C","D","+"}));
    }
}
