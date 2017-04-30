package Leetcode;

import java.util.Arrays;

public class _473 {
	public static void main(String[] args) {
		_473 a = new _473();
		a.execute();
	}

	public void execute() {
		int[] arr = { 7, 1, 13, 6, 19, 18, 12, 3, 15, 4, 20, 11, 2, 15, 14 };
		System.out.println(makesquare(arr));
	}

	public boolean makesquare(int[] nums) {
		if (nums.length == 0)
			return false;
		int sum = 0;
		int target;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		target = sum / 4;
		Arrays.sort(nums);
		reverse(nums);

		int[] dir = new int[4];
		return makesqureHelper(target, dir, nums, 0);

	}

	public boolean makesqureHelper(int target, int[] dir, int[] nums, int nP) {
		boolean result = false;
		if (nP == nums.length) {
			if (dir[0] == target && dir[1] == target && dir[2] == target) {
				return true;
			} else {
				return false;
			}
		} else {

			for (int i = 0; i < dir.length; i++) {
				if (dir[i] + nums[nP] <= target) {
					dir[i] += nums[nP];
					if (makesqureHelper(target, dir, nums, nP + 1)){
						return true;
					}
					dir[i] -= nums[nP];
				}
			}
			return result;

		}
	}

	public void reverse(int[] num) {
		int i = 0;
		int j = num.length - 1;
		while (i < j) {
			// swap
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i++;
			j--;
		}
	}
}
