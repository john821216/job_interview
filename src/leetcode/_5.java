package Leetcode;

public class _5 {
	public String longestPalindrome(String s) {
		int low;
		int high;
		int start = 0;
		int maxLength = 1;
		for (int i = 1; i < s.length(); i++) {
			// odd
			low = i - 1;
			high = i;
			while (low >= 0 && high < s.length()
					&& s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				low--;
				high++;
			}
			// even
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < s.length()
					&& s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				low--;
				high++;
			}
		}
		return s.substring(start, start + maxLength);
	}
}
