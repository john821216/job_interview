package Leetcode;

public class _486 {
	public static void main(String[] args){
		_486 a = new _486();
		a.execute();
	}
	
	public void execute(){
		System.out.println(PredictTheWinner(new int[]{1,5,2}));
	}
	
	public boolean PredictTheWinner(int[] nums) {
		int[][] dp = new int[nums.length + 1][nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			dp[i][i] = nums[i - 1];
		}

		for (int len = 2; len <= nums.length; len++) {
			for (int from = 1; from <= nums.length; from++) {
				int to = from + len - 1;
				if (to > nums.length) {
					break;
				}
				dp[from][to] = Math.max(nums[from - 1] - dp[from + 1][to],
						nums[to - 1] - dp[from][to - 1]);
			}
		}
		return dp[1][nums.length] > 0;
	}
}
