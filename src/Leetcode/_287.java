package Leetcode;

public class _287 {
	public static void main(String[] args){
		_287 a = new _287();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,3,4,2,2};
		System.out.println(findDuplicate2(arr));
	}
	public int findDuplicate(int[] nums) {
		int low = 1;
		int high = nums.length - 1;
		while(low < high){
			int mid = low + (high-low)/2;
			int count = 0;
			for(int i = 0 ; i < nums.length ; i++){
				if(nums[i] <= mid){
					count++;
				}
			}
			
			if(count > mid){
				high = mid;
			} else if (count <= mid){
				low = mid+1;
			}
			System.out.println(count + " " + mid +" " + low +" "+ " " + high);
		}
		return high;
	}
	
	public int findDuplicate2(int[] nums){
		int slow = nums[0];
		int fast = nums[nums[0]];
		while(slow != fast){
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		
		slow = 0;
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
