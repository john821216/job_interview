package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _30 {
	public static void main(String[] args) {
		_30 a = new _30();
		a.execute();
	}

	public void execute() {
		findSubstring("aaaaaaaa", new String[] { "aa",
				"aa","aa" });
	}

	public List<Integer> findSubstring(String s, String[] words) {
		int wordLen = words[0].length();
		List<Integer> an = new ArrayList<Integer>();
		HashMap<String, Integer> h;
		for (int i = 0; i < wordLen; i++) {
			int count = 0;
			int end = i;
			int start = i;
			h = new HashMap<String, Integer>();
			for (String str : words) {
				if (!h.containsKey(str)) {
					h.put(str, 1);
				} else {
					h.put(str, h.get(str) + 1);
				}
			}
			
			while (end < s.length() && end + wordLen <= s.length()) {
				String curEndWord = s.substring(end, end + wordLen);
				if (h.containsKey(curEndWord)) {
					if (h.get(curEndWord) == 0) {
						while (h.get(curEndWord) == 0) {
							String curStartWord = s.substring(start, start
									+ wordLen);
							if (h.containsKey(curStartWord)) {
								h.put(curStartWord, h.get(curStartWord) + 1);
								count--;
							}
							start += wordLen;
						}
					}

					h.put(curEndWord, h.get(curEndWord) - 1);
					count++;
					if (count == words.length) {
						an.add(start);
					}
					end += wordLen;

				} else {
					while (start < end) {
						String curStartWord = s.substring(start, start
								+ wordLen);
						if (h.containsKey(curStartWord)) {
							h.put(curStartWord, h.get(curStartWord) + 1);
						}
						start += wordLen;
						count = 0;
					}
					end += wordLen;
					start = end;
				}
			}
		}
		return an;
	}
}
