package me.vkku.twoPointer;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        Set<Character> characterSet = new HashSet<>();
        int maxArr = 0;
        int left = 0;
        for(Character ch : charArray){
            while(characterSet.contains(ch)){
                characterSet.remove(charArray[left++]);
            }
            characterSet.add(ch);
            maxArr = Math.max(characterSet.size(), maxArr);
        }
        return maxArr;
    }


    @Test
    public void driver(){
        LongestSubstring_3 longestSubstring = new LongestSubstring_3();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));  //3
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));     //1
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));    //3
        System.out.println(longestSubstring.lengthOfLongestSubstring(" "));         //1
    }
}
