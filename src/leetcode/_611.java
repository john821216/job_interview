package Leetcode;

import java.util.Arrays;

public class _611 {
    public int triangleNumber(int[] nums) {
    		int count = 0;
        Arrays.sort(nums);
        for(int i = nums.length-1 ; i >= 2 ; i--){
        		int cur = nums[i];
        		int l = 0;
        		int r = i-1;
        		while(l < r){
        			if(nums[l] + nums[r] > cur){
        				count += r-l;
        				r--;
        			} else{
        				l++;
        			}
        		}
        }
        return count;
    }
}
