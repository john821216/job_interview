package Leetcode;

import java.util.HashMap;

public class _560 {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		h.put(0, 1);
		int sum = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(h.containsKey(sum-k)){
				result += h.get(sum-k);
			}
			h.put(sum, h.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}
