package Leetcode;

public class _45 {
	public int jump(int[] nums) {
		int curMaxIdx = 0;
		int stepCount = 1;
		int nextMaxIdx = 0;
		curMaxIdx = nums[0];
		if(nums.length == 1) return 0;
		for (int i = 1; i < nums.length; i++) {
			if(i > curMaxIdx){
				stepCount++;
				curMaxIdx = nextMaxIdx;
			}
			nextMaxIdx = Math.max(nextMaxIdx,nums[i] +i);
		}
		return stepCount;
	}
}
