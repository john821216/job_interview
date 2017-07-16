package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _229 {
	public List<Integer> majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> an = new ArrayList<Integer>();
		if (nums.length == 1) {
			an.add(nums[0]);
			return an;
		}
		int count1 = 0;
		int count2 = 0;
		int number1 = nums[0];
		int number2 = nums[1];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == number1) {
				count1++;
			} else if (nums[i] == number2) {
				count2++;
			} else {
				if (count1 == 0) {	
					count1 = 1;
					number1 = nums[i];
				} else if (count2 == 0) {
					count2 = 1;
					number2 = nums[i];
				} else{
					count1--;
					count2--;
				}
			}
		}

		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == number1) {
				count1++;
			} else if (nums[i] == number2) {
				count2++;
			}
		}

		if (count1 > nums.length / 3) {
			an.add(number1);
		}

		if (count2 > nums.length / 3) {
			an.add(number2);
		}
		return an;
	}
}
