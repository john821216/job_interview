package leetcode;

public class _153 {
    public int findMin(int[] nums) {
    		int low = 0;
    		int high = nums.length-1;
    		while( low < high ){
    			if(nums[low] < nums[high]){
    				return nums[low];
    			}
    			
    			int mid = low + (high-low) / 2 ;
    			if(nums[mid] >= nums[low]){
    				low = mid + 1;
    			} else{
    				high = mid;
    			}
    		}
    		return nums[low];
    }
    
    public int findMin2(int[] nums){
       	int low = 0;
		int high = nums.length-1;
		while( low <= high ){
			if(nums[low] < nums[high]){
				return nums[low];
			}
			
			int mid = low + (high-low) / 2 ;
			if(nums[mid] >= nums[low]){
				low = mid + 1;
			} else{
				high = mid;
			}
		}
		return nums[high];
    }
}
