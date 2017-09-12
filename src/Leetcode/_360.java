package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _360 {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] sort = new int[nums.length];
		int start = 0;
		int end = nums.length - 1;
		int idx;
		if (a >= 0) {
			idx = nums.length - 1;
		} else {
			idx = 0;
		}
		while (start <= end) {
			if (a >= 0) {
				if (f(nums[start], a, b, c) > f(nums[end], a, b, c)) {
					sort[idx--] = f(nums[start++], a, b, c);
				} else {
					sort[idx--] = f(nums[end--], a, b, c);
				}
			} else {
				if (f(nums[start], a, b, c) < f(nums[end], a, b, c)) {
					sort[idx++] = f(nums[start++], a, b, c);
				} else {
					sort[idx++] = f(nums[end--], a, b, c);
				}
			}
		}
		return sort;
	}

	public int f(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
}
