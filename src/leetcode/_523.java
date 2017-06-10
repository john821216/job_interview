package Leetcode;

import java.util.HashMap;

public class _523 {
	public boolean checkSubarraySum(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				if (k == 0 && sum == k)
					return true;
				if (k != 0 && sum % k == 0)
					return true;
			}
		}
		return false;
	}

	public boolean checkSubarraySum2(int[] nums, int k) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (i > 0 && k != 0 && sum % k == 0) {
				return true;
			}
			if (i > 0 && k == 0 && sum == k) {
				return true;
			}

			if (k != 0) {
				sum %= k;
			}
			
			if(h.containsKey(sum)){
				int prev = h.get(sum);
				if(i-prev>1){
					return true;
				}
			} else{
				h.put(sum, i);
			}
			
		}
		return false;
	}
}
