package Leetcode;

public class _397 {
	public int integerReplacement(int n) {
		long n1 = n;
		int count = 0;
		while (n1 != 1) {
			if (n1 % 2 == 0) {
				count++;
				n1 /= 2;
			} else {
				if (n1 <= 3) {
					count += 2;
					n1 = 1;
				} else {
					if ((n1 + 1) % 4 == 0) {
						n1++;
					} else if ((n1 - 1) % 4 == 0) {
						n1--;
					}
					count++;
				}
			}
		}
		return count;

	}

	public int integerReplacement2(int n) {
		if (n == 1)
			return 0;
		if (n == Integer.MAX_VALUE)
			return 32;
		if (n % 2 == 0)
			return 1 + integerReplacement(n / 2);
		else
			return 1 + Math.min(integerReplacement(n - 1),
					integerReplacement(n + 1));
	}
}
