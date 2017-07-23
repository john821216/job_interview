package Leetcode;

public class _268 {
	public int missingNumber(int[] nums) {
		int total = (1 + nums.length) * nums.length / 2;
		for (int i = 0; i < nums.length; i++) {
			total -= nums[i];
		}
		return total;
	}
}
