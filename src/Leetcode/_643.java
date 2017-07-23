package Leetcode;

public class _643 {
	public double findMaxAverage(int[] nums, int k) {
		int val = 0;
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < k; i++) {
			val += nums[i];
			if (val > max) {
				max = val;
			}
		}
		idx = k;
		while (idx < nums.length) {
			val -= nums[idx-k];
			val += nums[k];
			if(val > max) {
				max = val;
			}
            idx++;
		}
		
		return (double)(max) /k;
	}
}
