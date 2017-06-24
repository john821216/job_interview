package Leetcode;

public class _504 {
	public String convertToBase7(int num) {
		if (num == 0)
			return "0";
		boolean isNegative = false;
		if (num < 0) {
			isNegative = true;
		}

		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.insert(0, Math.abs(num % 7));
			num /= 7;
		}
		if (isNegative) {
			sb.insert(0, "-");
		}

		return sb.toString();
	}
}
