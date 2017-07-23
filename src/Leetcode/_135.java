package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _135 {
	public static void main(String[] args) {
		_135 a = new _135();
		a.execute();
	}

	public void execute() {
		System.out.println(candy(new int[] { 1, 2 }));
	}

	// draw some pic
	public int candy(int[] ratings) {
		int[] nums = new int[ratings.length];
		Arrays.fill(nums, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i]) {
				nums[i] = nums[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i] < ratings[i - 1]) {
				nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
			}
		}
		int sum = 0;
		for (int i = 0; i < ratings.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
}
