package Leetcode;

public class _565 {
	public int arrayNesting(int[] nums) {
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			int curVisited = i;
			int size = 0;
			while (nums[curVisited] >= 0) {
				size++;
				int temp = nums[curVisited];
				nums[curVisited] = -1;
				curVisited = temp;
			}
			maxLength = Math.max(maxLength, size);
		}
		return maxLength;
	}
}
