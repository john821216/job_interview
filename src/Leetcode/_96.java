package Leetcode;

public class _96 {
	public static void main(String[] args) {
		_96 a = new _96();
		a.execute();
	}

	public void execute() {

	}

    public int numTrees(int n) {
     	int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			//left subtree's node count
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		return dp[n];   
	}
}
