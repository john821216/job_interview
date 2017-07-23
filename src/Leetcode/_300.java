package Leetcode;

import java.util.Arrays;

public class _300 {
	public static void main(String[] args) {
		_300 a = new _300();
		a.execute();
	}

	public void execute() {
		int[] arr = { -4, -1, 6, 3 };
		System.out.println(lengthOfLIS2(arr));
	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					if (dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}
		if (nums.length == 0)
			return 0;
		else
			return max;
	}

	public int lengthOfLIS2(int[] nums) {
		int size = 0;
		int[] tail = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			int from = 0;
			int end = size;
			while (from < end) {
				int mid = (end - from) / 2 + from;
				if (nums[i] > tail[mid]) {
					from = mid + 1;
				} else {
					end = mid;
				}
			}
			tail[from] = nums[i];
			if (from == size) {
				size++;
			}
		}
		return size;
	}

}
