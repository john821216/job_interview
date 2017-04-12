package leetcode;

public class _233 {
	public static void main(String[] args) {
		_233 a = new _233();
		a.execute();
	}

	public void execute() {
		System.out.println(countDigitOne(13));
	}

	public int countDigitOne(int n) {
		// 112
        long divider = 1;
		int a = 0;
		int b = 0;
		int count = 0;
		while (divider <= n) {
			a = (int)(n / (divider * 10));
			b = (int)(n % (divider * 10));
			int bDigit = (int)(b / divider);
			if (bDigit == 0) {
				count += a * divider;
			} else if (bDigit == 1) {
				count += a * divider + b % divider + 1;
			} else if (bDigit >= 2) {
				count += a * divider + divider;
			}
			divider *= 10;

		}
		return count;
	}
}
