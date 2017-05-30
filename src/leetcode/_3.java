package Leetcode;

import java.util.HashMap;

public class _3 {
	public static void main(String[] args) {
		_3 a = new _3();
		a.execute();
	}

	public void execute() {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		if (s.equals("")) {
			return 0;
		}

		int start = 0;
		int end = 0;
		int maxLength = 0;
		while (end < s.length()) {
			char endC = s.charAt(end);
			if (h.containsKey(endC) && h.get(endC) > 0) {
				h.put(endC, h.get(endC) + 1);
				while (start < end) {
					h.put(s.charAt(start), h.get(s.charAt(start)) - 1);
					if (h.get(s.charAt(start)) == 1) {
						start++;
						break;
					}
					start++;
				}
			} else {
				h.put(endC, 1);
			}
			maxLength = Math.max(maxLength, end - start + 1);
			end++;
		}
		return maxLength;
	}

	public int lengthOfLongestSubstring2(String s) {
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		int j = 0;
		int max =0;
		for (int i = 0; i < s.length(); i++) {
			if (h.containsKey(s.charAt(i))) {
				j = Math.max(j, h.get(s.charAt(i)) + 1);
			}
			
			h.put(s.charAt(i), i);
			max = Math.max(i-j+1, max);
		}
		return max;
	}
}
