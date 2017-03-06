package leetcode;

import java.util.concurrent.ThreadLocalRandom;

public class _462_2 {
	
	public static void main(String[] args){
		
		_462_2 a = new _462_2();
		int[] arr = {1,2,3};
		a.minMoves2(arr);
	}
	public int minMoves2(int[] nums) {
		int median = findMedian(nums, 0 , nums.length-1 , nums.length/2 );
		int sum = 0;
		for(int i = 0 ; i < nums.length ; i++){
			sum += Math.abs(median-nums[i]);
		}
		System.out.println(sum);
		return sum;
	}

	public int findMedian(int[] nums,int left ,int right ,int n) {
		int randomPivot = randomPivot(left, right);
		swap(nums,randomPivot, right);
		
		int pivot = nums[right];
		int storeIndex = left;
		for(int i = left; i < right ; i++){
			if(nums[i] < pivot){
				swap(nums, i , storeIndex);
				storeIndex++;
			}
		}
		swap(nums, storeIndex, right);
		
		if(storeIndex == n){
			return nums[n];
		} else if( n > storeIndex){
			return findMedian(nums, storeIndex+1 , right, n);
		} else{
			return findMedian(nums, left , storeIndex-1 , n);
		}
	}

	public int randomPivot(int left, int right) {
		return ThreadLocalRandom.current().nextInt(left, right + 1);
	}
	
	public void swap(int[] arr, int a , int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
