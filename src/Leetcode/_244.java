package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _244 {
	HashMap<String, ArrayList<Integer>> h;

	public _244(String[] words) {
		h = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < words.length; i++) {
			ArrayList<Integer> l;
			if (!h.containsKey(words[i])) {
				l = new ArrayList<Integer>();
			} else {
				l = h.get(words[i]);
			}
			l.add(i);
			h.put(words[i], l);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> l1 = h.get(word1);
		List<Integer> l2 = h.get(word2);
		int dis = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		while (i < l1.size() && j < l2.size()) {
			dis = Math.min(Math.abs(l1.get(i) - l2.get(j)), dis);
			if(l1.get(i) < l2.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return dis;
	}
}
