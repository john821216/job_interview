package Leetcode;

public class _162 {
	public static void main(String[] args){
		_162 a = new _162();
		a.execute();
	}
	
	public void execute(){
		int[] arr = { 1,4,3,2,1};
		int an = findPeakElement(arr);
		System.out.println(an);
	}
	
	public int findPeakElement(int[] nums) {
		int start = 0;
		int end = nums.length -1;
		while(true){
			if(start == end){
				return start;
			} else if( start + 1 == end){
				if(nums[start] > nums[end]){
					return start;
				} else {
					return end;
				}
			} else{
				int mid = start + (end - start) / 2;
				if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
					return mid;
				} else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
					start = mid + 1;
				} else{
					end = mid -1;
				}
			}
		}
	}
}
