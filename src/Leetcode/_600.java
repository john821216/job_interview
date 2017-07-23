package Leetcode;

public class _600 {
	public static void main(String[] args) {
		_600 a = new _600();
		a.execute();
	}

	public void execute() {
		findIntegers(3);
	}

	public int findIntegers(int num) {
		int[] dp = new int[32];
		dp[1] = 2;
		dp[2] = 3;
		for (int i = 3; i < 32; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		int an = 0;
		int preBit = 0;

		for (int i = 30; i >= 1; i--) {
			int cur = 1 << i;
			if ((cur & num) == cur) {
				an += dp[i];
				if (preBit == 1) {
					return an;
				}
				preBit = 1;
			} else {
				preBit = 0;
			}
		}

		//consider ....11   not good
		//         ....01
		//[....]1 we know that no consecutive twos appears ( otherwise it wont execute in here)
		//so only consider the case that may have consecutive one
		if ((num & 1) == 1 && (num & 2) == 0 ) {
			an += 1;
		}
		//[....]0 always be the case
		return an + 1;

	}
}
