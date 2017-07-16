package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _387 {
	public static void main(String[] args) {
		_387 a = new _387();
		a.execute();
	}

	public void execute() {
		System.out.println(firstUniqChar("loveleetcode"));
	}

	public int firstUniqChar(String s) {
		HashMap<Character, List<Integer>> h = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			List<Integer> getList = h.get(s.charAt(i));
			if (getList == null) {
				getList = new ArrayList<Integer>();
				getList.add(i);
				h.put(s.charAt(i), getList);
			} else {
				getList.add(i);
				h.put(s.charAt(i), getList);
			}
		}

		int minIdx = s.length();
		for (Map.Entry<Character, List<Integer>> m : h.entrySet()) {
			List<Integer> getList = m.getValue();
			if (getList.size() == 1) {
				minIdx = Math.min(minIdx, getList.get(0));
			}
		}
		if (minIdx == s.length()) {
			return -1;
		}
		return minIdx;
	}
}
