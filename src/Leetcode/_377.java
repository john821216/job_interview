package Leetcode;

public class _377 {
	public static void main(String[] args) {
		_377 a= new _377();
		a.execute();
	}
	
	public void execute() {
		System.out.println(combinationSum4(new int[] {1,2,3},4));
	}
	
	int count = 0;

	public int combinationSum4(int[] nums, int target) {
		combinationSum4Helper(nums, 0, target);
		return count;
	}

	public void combinationSum4Helper(int[] nums, int curVal, int target) {
		if (curVal == target) {
			count++;
			return;
		}

		if (curVal > target) {
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			combinationSum4Helper(nums, curVal + nums[i], target);
		}
	}
	
	public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target+1];
		dp[0] = 1;
		for(int i = 1; i <= target ; i++) {
			for(int j = 0 ; j < nums.length ; j++) {
				if(i-nums[j] >=0) {
					dp[i] += dp[i-nums[j]];
				}
			}
		}
		return dp[target];
	}
}
