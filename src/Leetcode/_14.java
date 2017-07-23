package Leetcode;

public class _14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		;
		String prefix = "";
		int index = 0;
		while (index < strs[0].length()) {
			char c = strs[0].charAt(index);
			for (int i = 1; i < strs.length; i++) {
				if (index >= strs[i].length() || strs[i].charAt(index) != c) {
					return prefix;
				}
			}
			index++;
			prefix += c;
		}
		return prefix;
	}
}
