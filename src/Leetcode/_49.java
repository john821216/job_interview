package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49 {

	public static void main(String[] args) {
		_49 a = new _49();
//		System.out.println(String.va);
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> h = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] curStr = strs[i].toCharArray();
			Arrays.sort(curStr);

			String cTostr = String.valueOf(curStr);
			if (h.get(cTostr) == null) {
				List<String> l = new ArrayList<String>();
				l.add(strs[i]);
				h.put(cTostr, l);

			} else {
				List<String> l = h.get(cTostr);
				l.add(strs[i]);
				h.put(cTostr, l);
			}
		}
		List<List<String>> ll = new ArrayList<List<String>>();

		for (String s : h.keySet()) {
			ll.add(h.get(s));
		}
		return ll;
	}
}
