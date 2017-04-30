package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class _290 {

	public static void main(String[] args) {
		_290 a = new _290();
		a.execute();
	}

	public void execute() {
		System.out.println(wordPattern2("abba", "dog cat cat cat"));
	}

	public boolean wordPattern(String pattern, String str) {
		if (pattern.length() != str.split(" ").length)
			return false;
		HashMap<Character, String> h = new HashMap<Character, String>();
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < pattern.length(); i++) {
			char p = pattern.charAt(i);
			String s = str.split(" ")[i];
			if (h.get(p) == null) {
				h.put(p, s);
				if (!hs.add(s)) {
					return false;
				}
			} else {
				if (!h.get(p).equals(s))
					return false;
			}
		}
		return true;
	}

	public boolean wordPattern2(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		HashMap index = new HashMap();
		for (int i = 0; i < words.length; ++i) {
			System.out.println(i);
			System.out.println(pattern.charAt(i)+" "+ index.put(pattern.charAt(i), i));
			System.out.println(words[i] +" " +index.put(words[i], i));
			System.out.println(index);
//			if (!Objects.equals(index.put(pattern.charAt(i), i),
//					index.put(words[i], i))){
//				System.out.println(index);
//				return false;
//			}
		}
		return true;
	}
}
