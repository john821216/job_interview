package Leetcode;

import java.util.HashSet;

public class _645 {
	public static void main(String[] args) {
		_645 a = new _645();
		a.execute();
	}
	
	public void execute() {
		findErrorNums(new int[] {1,2,2,4});
	}
	
	public int[] findErrorNums(int[] nums) {
		HashSet<Integer> h = new HashSet<Integer>();
		int len = nums.length;
		int[] an = new int[2];
		for (int i = 0; i < len; i++) {
			if (h.contains(nums[i])) {
				an[0] = nums[i];
			} else {
				h.add(nums[i]);
			}
		}
		System.out.println(h);

		for (int i = 1; i <= len; i++) {
			if (!h.contains(i)) {
				an[1] = i;
				break;
			} 
		}
		return an; 
    }
}
