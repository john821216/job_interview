package Leetcode;

import java.util.HashMap;

public class _266 {
	public static void main(String[] args) {
		_266 a = new _266();
		a.execute();
	}

	public void execute() {
		System.out.println(canPermutePalindrome("aaa"));
	}

	public boolean canPermutePalindrome(String s) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (char c : s.toCharArray()) {
			int idx = c - 'a';
			if (!h.containsKey(idx)) {
				h.put(idx, 1);
			} else {
				h.put(idx, h.get(idx) + 1);
			}
		}

		int oddCount = 0;
		for (int i : h.values()) {
			if (i % 2 == 1) {
				oddCount++;
			}
		}
		if (s.length() % 2 == 1) {
			if (oddCount == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			if (oddCount > 0) {
				return false;
			} else {
				return true;
			}
		}
	}
}
