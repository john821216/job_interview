package Leetcode;

public class _312 {
	public static void main(String[] args) {
		_312 a = new _312();
		a.execute();
	}

	public void execute() {
		System.out.println(maxCoins(new int[] { 3, 1, 5, 8 }));
	}

	public int maxCoins(int[] nums) {
		int[][] dp = new int[nums.length + 2][nums.length + 2];
		int[] newNums = new int[nums.length + 2];
		int idx = 1;
		newNums[0] = 1;
		newNums[newNums.length - 1] = 1;
		for (int i = 0; i < nums.length; i++) {
			newNums[idx++] = nums[i];
		}
			
		for (int len = 3; len <= dp.length; len++) {
			for (int start = 0; start + len - 1 < dp.length; start++) {
				int end = start + len - 1;
				for (int mid = start + 1; mid < end; mid++) {
					dp[start][end] = Math.max(dp[start][end],
							newNums[start] * newNums[mid] * newNums[end] + dp[start][mid] + dp[mid][end]);
					System.out.println(start +" " + mid +" " + end +" " +dp[start][end]);

				}
			}
		}
		return dp[0][dp.length - 1];
	}
}
