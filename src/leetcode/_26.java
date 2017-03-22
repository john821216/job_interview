package leetcode;

public class _26 {
	public int removeDuplicates(int[] nums) {
		int distinctIndex = 1;
		for(int i = 1; i < nums.length ; i++){
			if(nums[i] != nums[i-1]){
				nums[distinctIndex] = nums[i];
				distinctIndex++;
			}
		}
		return distinctIndex;
	}
}
