package Leetcode;

import java.util.Stack;

public class _456 {
	public boolean find132pattern(int[] nums) {
		// 1 3 2
		Stack<Integer> s = new Stack<Integer>();
		int s1 = Integer.MIN_VALUE;
		int s2 = Integer.MIN_VALUE;
		int s3 = Integer.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			s1 = nums[i];
			if (s1 < s3 && s3 < s2) {
				return true;
			}
			if (!s.isEmpty() && nums[i] > s.peek()) {
				s2 = nums[i];
			}

			while (!s.isEmpty() && nums[i] > s.peek()) {
				s3 = s.pop();
			}
			s.push(nums[i]);
		}
		return false;
	}
	
	public boolean find132pattern2(int[] nums) {
		int idx = 0;
		if(nums.length <= 2) return false;
		int s1=0;
		int s2=0;
		int s3=0;
		while(idx < nums.length){
			while(idx < nums.length-1 && nums[idx] >= nums[idx+1]){
				idx++;
			}
			s1 = idx;
			
			while(idx < nums.length-1 && nums[idx] <= nums[idx+1]){
				idx++;
			}
			
			s2 = idx;
			
			if(nums[s1] >= nums[s2]){
				idx++;
				continue;
			} else{
				int temp = idx;
				while(temp < nums.length){
					s3 = nums[temp++];
					if(s1 < s3 && s3 < s2){
						return true;
					}
				}
				idx = s2+1;
			}
		}
		return false;
	}
	
	
}
