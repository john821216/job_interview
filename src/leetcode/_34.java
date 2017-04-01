package leetcode;

public class _34 {
	public static void main(String[] args){
		_34 a = new _34();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {5,7,7,7,8,8,18};
		System.out.println(searchRange(arr,8)[0] +" " + searchRange(arr,8)[1]);
	}
	
	public int[] searchRange(int[] nums, int target) {
		int low = 0;
		int high = nums.length-1;
		int[] an = new int[2];
		an[0] = -1; an[1] = -1;
 		while(low <= high){
			int mid = low + (high-low)/2;
			if(nums[mid] < target){
				low = mid + 1;
			} else if(nums[mid] == target){
				if(mid -1 >= 0){
					if(nums[mid-1] != target){
						an[0] = mid;
						break;
					}
					else high = mid - 1;
				} else{
					an[0] = mid;
					break;
				}
			} else{
				high = mid - 1 ;
			}
		}
 		low = 0 ; high = nums.length-1;
 		while(low <= high){
 			int mid = low + (high-low) / 2;
 			if(nums[mid] == target){
 				if(mid + 1 < nums.length){
 					if(nums[mid+1] != target) {
 						an[1] = mid;
 						break;
 					}
 					else {
 						low = mid + 1;
 					}
 				} else{
 					an[1] = mid;
 					break;
 				}
 			} else if (nums[mid] > target){
 				high = mid - 1;
 			} else{
 				low = mid + 1;
 			}
 		}
 		return an;
	}
}
