package leetcode;

public class _283 {
	public void moveZeroes(int[] nums) {
		int curIndex = 0;
		if(nums == null || nums.length == 0) return;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[curIndex++] = nums[i];
			}
		}
		
		for(int i = curIndex ; i < nums.length ; i++){
			nums[i] = 0;
		}
	}
}
