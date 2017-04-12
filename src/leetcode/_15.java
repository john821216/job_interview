package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
	public static void main(String[] args) {
		_15 a = new _15();
		a.execute();
	}

	public void execute() {
		int[] arr = { 0, 0, 0,0};
		threeSum(arr);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			int curIndex = nums[i];
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				// important here
				if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
					if (nums[start] + nums[end] + curIndex == 0) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(nums[start]);
						l.add(nums[end]);
						l.add(nums[i]);
						ll.add(l);
						System.out.println(nums[start] +" " + nums[end]+ " "+ nums[i]); 
						int endVal = nums[end];
						while(end >= 0 && endVal == nums[end] ){
							end--;
						}
					} else if (nums[start] + nums[end] + curIndex < 0) {
						start++;
					} else {
						end--;
					}
				} else{
					break;
				}
			}
		}
		return ll;
	}
}
