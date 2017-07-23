package Leetcode;

import java.util.Arrays;

public class _414 {
	public int thirdMax(int[] nums) {
		long small, mid, max;
		small = mid = max = Long.MIN_VALUE;		
		
		for(int ele : nums){
			if(ele == max || ele == mid || ele == small) continue;
			if(ele > max){
				small = mid;
				mid = max;
				max = ele;
			} else if( ele > mid){
				small = mid;
				mid = ele;
			} else if( ele > small){
				small = ele;
			}
		}
		
		if(small == Long.MIN_VALUE) return (int)max;
		else return (int)small;
	}
}
