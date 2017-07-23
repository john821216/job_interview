package Leetcode;

public class _191 {
	public static void main(String[] args) {
		_191 a = new _191();
		a.execute();
	}

	public void execute() {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(hammingWeight(Integer.MAX_VALUE));
	}

	public int hammingWeight(int n) {
		int remaining = n;
		int ones = 0;
		if (n < 0) {
			remaining = n - Integer.MIN_VALUE;
			System.out.println(remaining);
			ones = 1;
		}
		while (remaining != 0) {
			if (remaining% 2 == 1)
				ones++;
			remaining = n / 2;
		}
		return ones;
	}
}
