package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _242 {
	public static void main(String[] args) {
		_242 a = new _242();
		a.execute();
	}

	public void execute() {
		System.out.println(isAnagram2("cda", "dac"));
	}

	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (h.get(s.charAt(i)) == null) {
				h.put(s.charAt(i), 1);
			} else {
				h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
			}
		}
		
		for(int i = 0 ; i < t.length() ; i++){
			if (h.get(t.charAt(i)) == null) {
				return false;
			} else if(h.get(t.charAt(i)) == 0){
				return false;
			} else{
				h.put(t.charAt(i), h.get(t.charAt(i)) - 1);
			}
		}
		return true;
	}
	
	public boolean isAnagram2(String s, String t){
		int[] alphabet = new int[26];
		for(int i = 0 ; i < s.length() ; i++){
			alphabet[s.charAt(i) - 'a']++;
		}
		
		for(int i = 0 ; i < t.length() ; i++){
			alphabet[t.charAt(i) - 'a']--;
		}
		
		for(int i = 0 ; i < alphabet.length ; i++){
			if(alphabet[i] != 0) return false;
		}
		return true;
	}
}
