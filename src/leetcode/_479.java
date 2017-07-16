package Leetcode;

public class _479 {
	public static void main(String[] args) {
		_479 a = new _479();
		a.execute();
	}

	public void execute() {
		largestPalindrome(2);
	}

	public int largestPalindrome(int n) {
		if (n == 1) {
			return 9;
		}

		long upperBound = (long) (Math.pow(10, n) - 1);
		long lowerBound = upperBound / 10;

		for (long i = upperBound; i > lowerBound; i--) {
			long cur = Long.valueOf(createPalindrome(i));
			System.out.println(cur);
			for (long j = upperBound; j > lowerBound; j--) {
				if (cur / j >= (long) Math.pow(10, n)) {
					break;
				}

				if (cur % j == 0) {
					return (int) (cur % 1337);
				}
			}
		}

		upperBound = lowerBound;
		lowerBound = upperBound / 10;

		for (long i = upperBound; i > lowerBound; i--) {
			for (int j = 1; j <= 9; j++) {
				long cur = Long.valueOf(createPalindromeWithCharacter(j, i));
				for (long k = upperBound; k > lowerBound; i--) {
					if (cur / k >= Math.pow(10, n)) {
						break;
					}

					if (cur % k == 0) {
						return (int) (cur % 1337);
					}
				}
			}
		}
		return -1;

	}

	public String createPalindrome(long l) {
		StringBuilder sb = new StringBuilder(l + "");
		return l + sb.reverse().toString();
	}

	public String createPalindromeWithCharacter(int i, long l) {
		StringBuilder sb = new StringBuilder(l + "" + i);
		return l + sb.reverse().toString();
	}
}
