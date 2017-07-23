package Leetcode;

public class _238 {
	public int[] productExceptSelf(int[] nums) {
		int[] an = new int[nums.length];
		an[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			an[i] = an[i - 1] * nums[i - 1];
		}

		int right = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			an[i] *= right;
			right *= nums[i];
		}
		return an;
	}
}
