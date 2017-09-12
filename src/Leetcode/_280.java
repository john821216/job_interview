package Leetcode;

import java.util.Arrays;

public class _280 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for (int i = 2; i < nums.length; i += 2) {
			int temp = nums[i];
			nums[i] = nums[i - 1];
			nums[i - 1] = temp;
		}
	}

	public void wiggleSort2(int[] nums) {
		//https://discuss.leetcode.com/topic/42605/my-explanations-of-the-best-voted-algo
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 0) {
				if (!(nums[i] >= nums[i - 1])) {
					swap(nums, i - 1, i);
				}
			} else {
				if (!(nums[i] <= nums[i - 1])) {
					swap(nums, i - 1, i);
				}
			}
		}
	}

	public void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
