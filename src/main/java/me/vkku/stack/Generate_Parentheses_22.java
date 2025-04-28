package me.vkku.stack;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
         //Base Case -> open == close == n
         // close < open
         // open < n
        List<List<String>> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        countParentheses(0, 0, n, result, stack);
        return result.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }


    public void countParentheses(int open, int close, int limit, List<List<String>> result, Stack<String>  stack){
        if((open == limit) && (close == limit)){
            result.add(List.of(String.join("", stack)));
            return;
        }
        if(open < limit){
            stack.push("(");
            countParentheses(open + 1, close, limit, result, stack);
            stack.pop();
        }
        if(close < open){
            stack.push(")");
            countParentheses(open, close + 1, limit, result, stack);
            stack.pop();
        }
    }

    @Test
    public void driver(){
        Generate_Parentheses_22 paren = new Generate_Parentheses_22();
        System.out.println(paren.generateParenthesis(1));
    }
}