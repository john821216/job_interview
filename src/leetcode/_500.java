package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class _500 {
	public static void main(String[] args){
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] result = findWords(words);
		
		for(int i =0 ; i < result.length ;i ++){
			System.out.println(result[i]+" ");
		}
	}
	public static String[] findWords(String[] words) {
		String[] str = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		ArrayList<String> findWords = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				h.put(str[i].charAt(j), i);
			}
		}

		for (int i = 0; i < words.length; i++) {
			int value = h.get(words[i].toLowerCase().charAt(0));
			boolean change = false;
			
			for(int j = 1; j < words[i].length() ; j++){
				if(h.get(words[i].toLowerCase().charAt(j)) != value){
					change = true;
				}
			}
			
			if(!change){
				findWords.add(words[i]);
			}
		}
		return findWords.toArray(new String[0]);
	}
}
