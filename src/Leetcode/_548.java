package Leetcode;

import java.util.HashSet;

public class _548 {

	public static void main(String[] args) {
		_548 a = new _548();
		a.execute();
	}

	public void execute() {
		System.out.println(splitArray(new int[] { 1, 2, 1, 2, 1, 2, 1 }));
	}

	public boolean splitArray(int[] nums) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int idx = 1; idx < sum.length; idx++) {
			sum[idx] = sum[idx - 1] + nums[idx];
		}

		for (int j = 3; j < nums.length - 3; j++) {
			HashSet<Integer> h = new HashSet<Integer>();
			// i
			for (int i = 1; i <= j - 2; i++) {
				int p1 = sum[i - 1];
				int p2 = sum[j - 1] - sum[i];
				if (p1 == p2) {
					h.add(p1);
				}
			}

			for (int k = j + 2; k < nums.length - 1; k++) {
				int p3 = sum[k - 1] - sum[j];
				int p4 = sum[nums.length - 1] - sum[k];
				if(p3==p4 && h.contains(p3)) {
					return true;
				}
			}
		}
		return false;
	}
}
