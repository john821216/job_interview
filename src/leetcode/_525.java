package Leetcode;

import java.util.HashMap;

public class _525 {
	public static void main(String[] args) {
		_525 a = new _525();
		a.execute();
	}

	public void execute() {
		int[] arr = { 0, 1, 0 };
		System.out.println(findMaxLength(arr));
	}

	public int findMaxLength(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
			if (i > 0) {
				nums[i] += nums[i - 1];
			}

		}

		int max = 0;
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {

			if (h.containsKey(nums[i])) {
				int pre = h.get(nums[i]);
				max = Math.max(max, i - pre);
			} else if (nums[i] == 0) {
				max = Math.max(max, i+1);
			} else{
				h.put(nums[i], i);
			}
		}
		return max;
	}
}
