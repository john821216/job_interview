package Leetcode;

public class _487 {
	public int findMaxConsecutiveOnes(int[] nums) {
        int start =0;
        int end = 0;
        int zero = 0;
        int k =1;
        int max = 0;
        while(end < nums.length) {
        		if(nums[end] ==0) {
        			zero++;
        		}
        		
        		while(zero > k) {
        			if(nums[start] ==0) {
        				zero--;
        			}
        			start++;
        		}
        		max = Math.max(max, end-start+1);
        		end++;
        }
        return max;
    }
}
