package leetcode;

public class _172 {
	public int trailingZeroes(int n) {
		int fiveFactor = 0;
		long five = 5;

		while (five <= n) {
			fiveFactor += n / five;
			five *= 5;
		}
		return fiveFactor;
	}

	public int trailingZeroes2(int n) {
		if (n == 0) {
			return 0;
		}
		return n / 5 + trailingZeroes2(n / 5);
	}
}
