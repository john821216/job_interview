package Leetcode;

public class _41 {
	
	public static void main(String[] args){
		_41 a = new _41();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {2,1};
		firstMissingPositive(arr);
	}
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[i];
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}
		
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] != i+1){
				return i+1;
			}
		}
		return nums.length+1;
	}
}
