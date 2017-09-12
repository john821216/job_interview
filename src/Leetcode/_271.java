package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _271 {
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder encodeStr = new StringBuilder();
		for (String s : strs) {
			encodeStr.append(s.length() + "/" + s);
		}
		return encodeStr.toString();

	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		int idx = 0;
		List<String> l = new ArrayList<String>();
		while(idx < s.length()) {
			int slash = s.indexOf("/", idx);
			int len = Integer.valueOf(s.substring(idx, slash));
			l.add(s.substring(slash+1, slash+1+len));
			idx = slash + 1 + len;
		}
		return l;
		

	}
}
