package Leetcode;

public class _35 {
	public int searchInsert(int[] nums, int target) {
		int low = 0; 
		int high = nums.length-1;
		int noFoundIndex = 0;
		while(low <= high){
			int mid = (high-low)/2 + low;
			if(nums[mid] == target){
				return mid;
			} else if( nums[mid] > target){
				high = mid -1;
				noFoundIndex = mid;
			} else{
				low = mid+ 1 ;
				noFoundIndex = mid+1;
			}
		}
		return noFoundIndex;
	}
}
