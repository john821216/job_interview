package Leetcode;

import java.util.HashMap;

public class _325 {
	public static void main(String[] args) {
		_325 a = new _325();
		a.execute();
	}

	public void execute() {
		System.out.println(maxSubArrayLen(new int[] {-2,1,-3,4,-1,2,1,-5,4}, 6));
	}

	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int sum = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				max = i + 1;
			}
			h.put(sum, i);
		}
		sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (h.containsKey(k + sum)) {
				if (h.get(k + sum) > i) {
					max = Math.max(max, h.get(k + sum) - i);
				}
			}
		}
		return max;
	}
}
