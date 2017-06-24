package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18 {
	public static void main(String[] args) {
		_18 a = new _18();
		a.execute();
	}

	public void execute() {
		int[] num = {-3,-2,-1,0,0,1,2,3 };
		fourSum(num, 0);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> ll = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int sum;
		for (int i = 0; i < nums.length; i++) {
			if(i!= 0 && nums[i] == nums[i-1]){
				continue;
			}
			int j = i + 1;			
			while (j < nums.length - 1) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					j++;
					continue;
				}
				sum = nums[i] + nums[j];
				int curTarget = target - sum;
				int start = j + 1;
				int end = nums.length - 1;
				while (start < end) {
					if (start != j + 1 && nums[start] == nums[start - 1]) {
						start++;
						continue;
					}

					if (end + 1 <= nums.length - 1
							&& nums[end] == nums[end + 1]) {
						end--;
						continue;
					}

					if (nums[start] + nums[end] > curTarget) {
						end--;
					} else if (nums[start] + nums[end] < curTarget) {
						start++;
					} else {
						ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[start]);
						l.add(nums[end]);
						ll.add(l);
						System.out.println(l);
						start++;
					}
				}
				j++;
			}
		}
		return ll;
	}
}
