package Leetcode;

public class _477 {
	public int totalHammingDistance(int[] nums) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			int zeroC = 0;
			int oneC = 0;
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & 1) == 0)
					zeroC++;
				if ((nums[j] & 1) == 1)
					oneC++;
				nums[j] >>= 1;
			}
			count += zeroC * oneC;
		}
		return count;
	}
}
