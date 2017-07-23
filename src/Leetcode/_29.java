package Leetcode;

public class _29 {
	public static void main(String[] args) {
		_29 a = new _29();
		a.execute();
	}

	public void execute() {
		divide(-1566834001, 360941337);
	}

	public int divide(int dividend, int divisor) {
		boolean minValueAbsOverFlow = false;
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == Integer.MIN_VALUE) {
			if (divisor == 1) {
				return Integer.MIN_VALUE;
			} else if (divisor == -1) {
				return Integer.MAX_VALUE;
			} else if (divisor == Integer.MIN_VALUE) {
				return 1;
			} else {
				minValueAbsOverFlow = true;
			}
		}
		if (divisor == Integer.MIN_VALUE) {
			return 0;
		}

		int sign = 1;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			sign = -1;
		}
		if (minValueAbsOverFlow) {
			dividend = dividend + 1;
		}

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int count = 0;
		while (dividend >= divisor) {
			int temp = divisor;
			int mul = 1;
			while (temp < (Integer.MAX_VALUE>>2) && dividend >= (temp << 2)) {
				temp <<= 2;
				mul <<= 2;
			}
			System.out.println(mul);
			count += mul;
			dividend -= temp;
			if (minValueAbsOverFlow) {
				dividend += 1;
				minValueAbsOverFlow = true;
			}
		}
		System.out.println(count + " "+ sign);
		return count * sign;
	}
}
