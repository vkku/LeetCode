package me.vkku.arrays;

import org.junit.jupiter.api.Test;

public class Valid_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        int[] histogram = new int[10000];
        boolean anagram = true;
        for(int i = 0 ; i < s.length() ; i++){
            histogram[s.charAt(i)] += 1;
        }

        for(int i = 0 ; i < t.length() ; i++){
            histogram[t.charAt(i)] -= 1;
        }

        for(int i = 0 ; i < 10000 ; i++){
            if (histogram[i] != 0) {
                anagram = false;
                break;
            }
        }
        return anagram;
    }

    @Test
    public void driver(){
        Valid_Anagram_242 anagram = new Valid_Anagram_242();
        System.out.println(anagram.isAnagram("anagram", "nagaram"));
    }
}
