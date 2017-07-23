package Leetcode;

import java.util.Arrays;

public class _581 {
	public static void main(String[] args) {
		_581 a = new _581();
		a.execute();
	}

	public void execute() {
		int[] arr = { 2, 6, 4, 8, 9, 10, 15 };
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		findUnsortedSubarray2(arr);
	}

	public int findUnsortedSubarray(int[] nums) {
		int[] sort = new int[nums.length];
		for (int i = 0; i < sort.length; i++) {
			sort[i] = nums[i];
		}
		Arrays.sort(sort);
		int start = 0;
		int end = nums.length - 1;
		while (start < nums.length && nums[start] == sort[start]) {
			start++;
		}
		while (end > start && nums[end] == sort[end]) {
			end--;
		}
		return end - start + 1;
	}

	public int findUnsortedSubarray2(int[] nums) {
		int start = 0;
		int end = 0;
		int cur = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[cur]) {
				end = i;
			} else if (nums[i] > nums[cur]) {
				cur = i;
			}
			System.out.println(cur +" " +end);
		}
		System.out.println(nums[end] +" " + nums[cur]);

		cur = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[cur]) {
				cur = i;
			} else if (nums[i] > nums[cur]) {
				start = i;
			}
		}

		if (start == 0 && end == 0) {
			return 0;
		} else {
			return end - start + 1;
		}
	}
}
