package me.vkku.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IsomorphicString_205 {
    public boolean isIsomorphic(String s, String t) {
        char[] string1 = s.toCharArray();
        char[] string2 = t.toCharArray();
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(string1[i]) != null) {
                if (string2[i] != charMap.get(string1[i]))
                    return false;
            } else {
                if (new HashSet<>(charMap.values()).contains(string2[i]))
                    return false;
                charMap.put(string1[i], string2[i]);
            }
        }
        return true;
    }
}
