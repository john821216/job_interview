package Leetcode;

import java.util.HashMap;

public class _76 {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			if (h.containsKey(c)) {
				h.put(c, h.get(c) + 1);
			} else {
				h.put(c, 1);
			}
		}

		int start = 0;
		int end = 0;
		int counter = t.length();
		int minLen = Integer.MAX_VALUE;
		int startIdx=0;
		while (end < s.length()) {
			if(!h.containsKey(s.charAt(end))) {
				h.put(s.charAt(end), 0);
			}
			if (h.get(s.charAt(end)) > 0) {
				counter--;
			}
			h.put(s.charAt(end), h.get(s.charAt(end)) - 1);

			while (counter == 0) {
				if (end - start + 1 < minLen) {
					minLen = end - start + 1;
					startIdx = start;
				}
				h.put(s.charAt(start), h.get(s.charAt(start)) + 1);
				if(h.get(s.charAt(start)) > 0) {
					counter++;
				}
				start++;
			}
			end++;
		}
		
		if(minLen ==Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(startIdx, startIdx+minLen);
	}
}
