package Leetcode;

public class _27 {
	public static void main(String[] args){
		_27 a = new _27();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,2,1};
		System.out.println(removeElements3(arr,1));
		for(int i = 0 ; i < arr.length ; i++){
			System.out.println(arr[i]);
		}
	}
	
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for(int j = 0 ; j < nums.length ; j++){
			if(nums[j] != val){
				int temp  = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		return i;
	}
	
	public int removeElement2(int[] nums, int val) {
		int i = 0;
		for(int j = 0 ; j < nums.length ; j++){
			if(nums[j] != val){
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
	
	public int removeElements3(int[] nums, int val){
		int start = 0;
		int end = nums.length-1;
		while(start <= end){
			if(nums[start] != val){
				start++;
			} else{
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				end--;
			}
		}
		return start;
	}
}
