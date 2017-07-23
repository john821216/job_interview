package Leetcode;

import java.util.Arrays;

public class _215 {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public int findKthLargest2(int[] nums, int k) {
        return findKthHelper(nums, 0, nums.length - 1, nums.length-k);
	}

	public int findKthHelper(int[] nums, int left, int right, int k) {
		int range = right - left + 1;
		int randomIndex = (int) (Math.random() * range) + left;
		int pivot;
		int storeIndex = left;
		//swap with right
		int temp = nums[right];
		nums[right] = nums[randomIndex];
		nums[randomIndex] = temp;
		pivot = nums[right];
		for(int i = left; i < right ; i++){
			if(nums[i] < pivot){
				//swap
				temp = nums[storeIndex];
				nums[storeIndex] = nums[i];
				nums[i] = temp;
				storeIndex++;
			}
		}
		
		//swap
		temp = nums[storeIndex];
		nums[storeIndex] = nums[right];
		nums[right] = temp;
		
		if(storeIndex == k){
			return nums[storeIndex];
		} else if(storeIndex > k){
			return findKthHelper(nums, left, storeIndex-1, k);
		} else{
			return findKthHelper(nums, storeIndex+1, right, k); 
		}
	}

}
