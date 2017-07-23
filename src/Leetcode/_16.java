package Leetcode;

import java.util.Arrays;

public class _16 {
	public static void main(String[] args){
		_16 a = new _16();
		a.execute();
	}
	
	public void execute(){
		int[] ar = {-1 ,2 ,1, -4};
		System.out.println(threeSumClosest(ar,1));
	}
	
	public int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int closeSum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i+1;
			int end = nums.length-1;
			while(start < end){
				int curSum = nums[i] + nums[start] + nums[end];
				System.out.println(nums[i] +" " + nums[start] +" "+ nums[end]);
				if(Math.abs(curSum-target) < min){
					min = Math.abs(curSum-target);
					closeSum = curSum;
				}
				if(curSum > target){
					end--;
				} else if(curSum < target){
					start++;
				} else{
					return curSum;
				}
			}
		}
		return closeSum;
	}
}
