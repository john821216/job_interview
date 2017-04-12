package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _503 {
	public int[] nextGreaterElements(int[] nums) {
		int[] nums_ = new int[nums.length * 2];
		Stack<Integer> s = new Stack<Integer>();
		int[] an = new int[nums.length];
		Arrays.fill(an, -1);
		for (int i = 0; i < nums_.length; i++) {
			nums_[i] = nums[i];
			nums_[i + nums.length] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			//next ele
			int num = nums_[i];
			while(!s.isEmpty() && nums_[s.peek()] < num){
				an[nums_[s.pop()]] = num;
			}
			if(i < nums_.length /2){
				s.push(nums_[i]);
			}
		}
		return an;
	}
}
