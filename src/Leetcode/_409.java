package Leetcode;

import java.util.HashMap;

public class _409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char curC = s.charAt(i);
            if(h.get(curC) == null){
                h.put(curC,1);
            } else{
                h.put(curC, h.get(curC)+1);
                if(h.get(curC) % 2 ==0){
                    count +=2;
                }
            }
        }
        
        if(s.length() - count >= 1){
            count++;
        }
        return count;
    }
}
