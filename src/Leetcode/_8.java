package Leetcode;

public class _8 {
	public int myAtoi(String str) {
		if (str.length() == 0 || str == null) {
			return 0;
		}

		int idx = 0;
		int sign = 1;
		while (idx < str.length() && str.charAt(idx) == ' ') {
			idx++;
		}

		if (str.charAt(idx) == '-' || str.charAt(idx) == '+') {
			if (str.charAt(idx) == '-') {
				sign = -1;
			} else {
				sign = 1;
			}
			idx++;
		}

		int total = 0;
		while (idx < str.length()) {
			int digit = str.charAt(idx) - '0';
			if (!(digit >= 0 && digit <= 9)) {
				break;
			}

			if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
				if (sign == 1) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
			total = total * 10 + digit;
		}
		return total * sign;
	}
}
