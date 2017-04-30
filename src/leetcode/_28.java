package Leetcode;

public class _28 {
	public int strStr(String haystack, String needle) {
		if (needle.equals("")) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int firstIdx = 0;
		while (i < haystack.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (j == 0)
					firstIdx = i;
				i++;
				j++;
			} else {
				if (j != 0) {
					i = firstIdx + 1;
					j = 0;
				} else {
					i++;
				}

			}
			if (j == needle.length()) {
				return firstIdx;
			}
		}
		return -1;
	}
}
