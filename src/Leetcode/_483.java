package Leetcode;

import java.math.BigInteger;

public class _483 {
	public static void main(String[] args) {
		_483 a = new _483();
		a.execute();
	}

	public void execute() {
		System.out.println(smallestGoodBase("821424692950225218"));
	}

	public String smallestGoodBase(String n) {
		int m = (int) (Math.log(Long.parseLong(n)) / Math.log(2.0));
		for (int i = m; i >= 1; i--) {
			if (isGoodBase(n, i)) {
				if (i == 1) {
					return Long.parseLong(n) - 1 + "";
				} else {
					return (long) (Math.ceil(Math.pow(Long.parseLong(n),
							1.0 / (double) i))) - 1 + "";
				}
			}
		}
		return "";
	}

	public boolean isGoodBase(String n, long m) {

		long k;
		if (m == 1) {
			k = Long.parseLong(n) - 1;
		} else {
			k = (long) (Math.ceil(Math.pow(Long.parseLong(n),
					(double) (1.0 / m)))) - 1;
		}
		long sum = 0;
		long base = 1;
		for (int i = 0; i <= m; i++) {
			sum += base;
			base *= k;
		}

		return sum == Long.parseLong(n);
	}
}
