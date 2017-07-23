package Leetcode;

public class _494 {
	int count = 0;
	
	public static void main(String[] args){
		_494 a = new _494();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,1,1,1,1};
		findTargetSumWays(arr,3);
	}

	public int findTargetSumWays(int[] nums, int S) {
		findTargetSumWaysHelper(nums, 0, 0, S);
		System.out.println(count);
		return count;
	}

	public void findTargetSumWaysHelper(int[] nums, int start, int cur ,int S) {
		if(start == nums.length){
			if(cur== S) count++;
			return;
		}
		findTargetSumWaysHelper(nums, start + 1, cur + nums[start] * 1, S);
		findTargetSumWaysHelper(nums, start + 1, cur + nums[start] * -1, S);
	}
}
