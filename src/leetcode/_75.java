package Leetcode;

public class _75 {
	//http://algs4.cs.princeton.edu/lectures/23DemoPartitioning.pdf
	public void sortColors(int[] nums) {
		int rCount = 0;
		int wCount = 0;
		int bCount = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				rCount++;
			if (nums[i] == 1)
				wCount++;
			if (nums[i] == 2)
				bCount++;
		}
		int curIndex = 0;
		while (rCount != 0) {
			nums[curIndex++] = 0;
		}

		while (wCount != 0) {
			nums[curIndex++] = 1;
		}

		while (bCount != 0) {
			nums[curIndex++] = 2;
		}
	}

	public void sortColor2(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int i = 0;
		while (i <= high) {
			if(nums[i] == 0){
				int temp = nums[i];
				nums[i] = nums[low];
				nums[low] = temp;
				low++; i++; 
			} else if(nums[i] == 1){
				i++;
			} else{
				int temp = nums[i];
				nums[i] = nums[high];
				nums[high] = temp;
				high--; 
			}
		}
	}
}
