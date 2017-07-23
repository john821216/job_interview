package Leetcode;

public class _376 {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int length = 1;
		int cur = nums[0];
		int state = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			int delta = nums[i] - cur;
			if (delta == 0) {
				// do nothing
				continue;
			} else if (delta > 0) {
				if (state == 0 || state == 2) {
					length++;
				}
				state = 1;
			} else {
				if (state == 0 || state == 1) {
					length++;
				}
				state = 2;
			}
		}
		if (length == 1) {
			return 0;
		} else {
			return length;
		}
	}
}
