package Leetcode;

public class _482 {
	public String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		S = S.toUpperCase();

		int count = K;
		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) != '-') {
				if (count == 0) {
					sb.insert(0, "-");
					count = K;
				}
				sb.insert(0, S.charAt(i));
				count--;
			}
		}
		return sb.toString();
	}
}
