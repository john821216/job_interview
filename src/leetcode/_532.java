package Leetcode;

import java.util.Arrays;

public class _532 {
	public static void main(String[] args) {
		_532 a = new _532();
		a.execute();
	}

	public void execute() {
		int[] arr = {2, 3, 4, 6, 6, 6, 7, 7, 9, 9  };
		findPairs(arr, 3);
	}

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int i = 0;
		int j = 0;
		int count = 0;
		while (i < nums.length) {
			while (i < nums.length && i > 0 && nums[i] == nums[i - 1]) {
				i++;
			}
			
			if (i == nums.length){
				break;
			}
			
			int second = nums[i] + k;
			j = i + 1;

			while (j < nums.length && nums[j] != second) {
				j++;
			}
			
			if (j < nums.length) {
				count++;
			}
			
			i++;
		}
		return count;
	}
}
