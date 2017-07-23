package Leetcode;

public class _198 {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = nums[i];
			if (dp[i] > max) {
				max = dp[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int maxJval = 0;
			for (int j = 0; j < i - 1; j++) {
				if (dp[j] > maxJval) {
					maxJval = dp[j];
				}
			}
			dp[i] = maxJval + dp[i];
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	public int rob2(int[] num) {
		int[][] dp = new int[num.length + 1][2];
		for (int i = 1; i <= num.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = num[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[num.length][0], dp[num.length][1]);
	}

	public int rob3(int[] num) {
		int prevNo = 0;
		int prevYes = 0;
		for (int i = 0; i < num.length; i++) {
			int temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = num[i] + temp;
		}
		return Math.max(prevNo, prevYes);
	}
}
