package me.vkku.stack;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    <!-- Describe your first thoughts on how to solve this problem. -->
    Since parentheses occurs in pairs, it's wise approach to use stack.

    # Approach
    <!-- Describe your approach to solving the problem. -->
    Push opening parentheses into stack and pop when closing parentheses is encountered,
    this way if stack is empty at the end of operation it implies string has balanced parentheses.

    # Complexity
    - Time complexity:
    <!-- Add your time complexity here, e.g. $$O(n)$$ -->
    O(n)

    - Space complexity:
    <!-- Add your space complexity here, e.g. $$O(n)$$ -->
    O(n)
 */

public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        Map<String, String> matchingParentheses = new HashMap<>();
        Stack<String> parenthesesStack = new Stack<>();
        matchingParentheses.put(")", "(");
        matchingParentheses.put("}", "{");
        matchingParentheses.put("]", "[");
        for(char c : s.toCharArray()){
            String current = String.valueOf(c);
            if(matchingParentheses.containsKey(current) && !parenthesesStack.isEmpty() && parenthesesStack.peek().equals(matchingParentheses.get(current))){
                parenthesesStack.pop();
            }
            else{
                parenthesesStack.push(current);
            }
        }
        return parenthesesStack.empty();
    }

    @Test
    public void driver(){
        Valid_Parentheses_20 paren = new Valid_Parentheses_20();
        System.out.println(paren.isValid("]"));
    }
}
