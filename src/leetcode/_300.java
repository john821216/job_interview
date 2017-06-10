package Leetcode;

import java.util.Arrays;

public class _300 {
	public static void main(String[] args) {
		_300 a = new _300();
		a.execute();
	}

	public void execute() {
		int[] arr = { -4, -1, 6, 3 };
		lengthOfLIS2(arr);
	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					if (dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}
		if (nums.length == 0)
			return 0;
		else
			return max;
	}

	public int lengthOfLIS2(int[] nums) {
		int[] tails = new int[nums.length];
		tails[0] = nums[0];
		int s = 0;
		int e = 0;
		int curEnd = 0;
		for (int i = 1; i < nums.length; i++) {
			while (s != e) {
				int m = (e - s) / 2 + e;
				if (tails[m] < nums[i]) {
					s = m + 1;
				} else {
					e = m;
				}
			}

			if (s > curEnd) {
				e = curEnd + 1;
				tails[e] = nums[i];
			} else {
				e = curEnd;
				
			}
			s = 0;
		}

	}

}
