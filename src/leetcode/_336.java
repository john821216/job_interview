package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _336 {
	// palindrome =>
	// a + palindrome + a.reverse
	// a.reverse + palindrome + a
	public List<List<Integer>> palindromePairs(String[] words) {
		HashMap<String, Integer> hp = new HashMap<String, Integer>();
		HashSet<List<Integer>> h = new HashSet<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			hp.put(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);

				if (isPalindrome(s1)) {
					String s2Reverse = new StringBuilder(s2).reverse()
							.toString();
					if (hp.containsKey(s2Reverse) && hp.get(s2Reverse) != i) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(hp.get(s2Reverse));
						l.add(i);
						h.add(l);
					}
				}
				
				if (isPalindrome(s2)) {
					String s1Reverse = new StringBuilder(s1).reverse()
							.toString();
					if (hp.containsKey(s1Reverse) && hp.get(s1Reverse) != i) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(i);
						l.add(hp.get(s1Reverse));
						h.add(l);
					}
				}
			}
		}
		List<List<Integer>> an = new ArrayList<List<Integer>>(h);
		return an;
	}

	public boolean isPalindrome(String s) {
		if (s.equals("")) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}
}
