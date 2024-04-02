package me.vkku.string;

import java.util.Arrays;

public class LastWordLength_58 {
    public int lengthOfLastWord(String s) {
        String[] stringArr = s.split(" ");
         return stringArr[stringArr.length - 1].length();
    }
}
