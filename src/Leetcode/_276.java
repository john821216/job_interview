package Leetcode;

public class _276 {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}

		if (n == 1) {
			return k;
		}

		int dif = k * (k - 1);
		int same = k;
		for (int i = 3; i <= n; i++) {
			int temp = dif;
			dif = (dif + same) * (k - 1);
			same = temp;
		}
		return dif + same;

	}
}
