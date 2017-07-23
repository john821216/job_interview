package Leetcode;

public class _154 {
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low != high) {
			int mid = (high - low) / 2 + low;
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else if (nums[mid] < nums[high]) {
				high = mid;
			} else {
				high--;
			}
		}
		return nums[low];
	}
}
