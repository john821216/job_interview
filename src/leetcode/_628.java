package Leetcode;

public class _628 {
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int a = nums[nums.length - 1] * nums[nums.length - 2]
				* nums[nums.length - 3];
		int b = nums[0] * nums[1] * nums[nums.length - 1];
		return Math.max(a, b);
	}
}
