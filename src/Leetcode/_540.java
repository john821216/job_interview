package Leetcode;

public class _540 {
	public int singleNonDuplicate(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start != end) {
			int mid = (end - start) / 2 + start;

			if (mid % 2 == 1) {
				mid -= 1;
			}

			if (nums[mid] != nums[mid + 1]) {
				end = mid;
			} else {
				start = mid + 2;
			}
		}
		return nums[start];
	}
}
