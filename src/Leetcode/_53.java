package Leetcode;

public class _53 {
	public static void main(String[] args) {
		_53 a = new _53();
		a.execute();
	}

	public void execute() {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray2(arr));
	}

	public int maxSubArray(int[] nums) {
		int[] sum = new int[nums.length + 1];
		int max = Integer.MIN_VALUE;
		sum[0] = 0;
		for (int i = 1; i < sum.length; i++) {
			sum[i] = Math.max(nums[i - 1], nums[i - 1] + sum[i - 1]);
			if (sum[i] > max) {
				max = sum[i];
			}
		}
		return max;
	}

	// divide and conqure
	public int maxSubArray2(int[] nums) {
		return maxSubArrayHelper(nums, 0, nums.length - 1);
	}

	public int maxSubArrayHelper(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int mid = start + (end - start) / 2;
		return Math.max(
				maxSubArrayHelper(nums, start, mid),
				Math.max(maxSubArrayHelper(nums, mid + 1, end),
						maxCrossSum(nums, start, mid, end)));
	}

	public int maxCrossSum(int[] nums, int start, int mid, int end) {
		int leftSum = 0;
		int maxLeftSum =Integer.MIN_VALUE;
		
		int rightSum = 0;
		int maxRightSum = Integer.MIN_VALUE;
		for (int i = mid; i >= start; i--) {
			leftSum += nums[i];
			if(leftSum > maxLeftSum){
				maxLeftSum = leftSum;
			}
		}
		
		for (int i = mid+1; i <=end ; i++) {
			rightSum += nums[i];
			if(rightSum > maxRightSum){
				maxRightSum = rightSum;
			}
		}
		return maxLeftSum + maxRightSum;
	}
}
