package Leetcode;

import java.util.Arrays;

public class _259 {
	public static void main(String[] args) {
		_259 a = new _259();
		a.execute();
	}

	public void execute() {
		threeSumSmaller(new int[] { 3, 1, 0, -2 }, 4);
	}

	public int threeSumSmaller(int[] nums, int target) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			int t = target - nums[i];
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum < t) {
					count += right - left;
					left++;
				} else {
					right--;
				}
			}
		}
		return count;
	}
}
