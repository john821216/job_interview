package leetcode;

public class _209 {
	public static void main(String[] args) {
		_209 a = new _209();
		a.execute();
	}

	public void execute() {
		int[] arr = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen3(7, arr));
	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int left = 0;
		int right = 0;
		int sum = nums[0];
		int minLen = Integer.MAX_VALUE;
		while (true) {
			if (sum < s) {
				right++;
				if (right < nums.length) {
					sum += nums[right];
				} else {
					break;
				}
			} else if (sum >= s) {
				int curLen = right - left + 1;
				if (curLen < minLen) {
					minLen = curLen;
				}
				if (left == right) {
					return 1;
				} else {
					sum -= nums[left];
					left++;
				}
			}
			System.out.println(left + " " + right + " " + sum);
		}
		if (minLen == Integer.MAX_VALUE) {
			return 0;
		} else {
			return minLen;
		}
	}

	public int minSubArrayLen2(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		int j = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		while (j < nums.length) {
			sum += nums[j++];

			while (i < j && sum >= s) {
				int curLen = j - i;
				if (curLen < minLen) {
					minLen = curLen;
				}
				sum -= nums[i++];
			}
		}
		if (minLen == Integer.MAX_VALUE) {
			return 0;
		} else {
			return minLen;
		}
	}

	public int minSubArrayLen3(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int minLen = Integer.MAX_VALUE;
		int[] sums = new int[nums.length + 1];
		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			int j = binaryS(sums, i + 1, sums.length - 1, s + sums[i]);
			if (j != -1 && j - i < minLen) {
				System.out.println(j + " " + i);
				minLen = j - i;
			}
		}
		if (minLen == Integer.MAX_VALUE) {
			return 0;
		} else {
			return minLen;
		}
	}

	public int binaryS(int[] sums, int s, int e, int target) {
		while (s < e) {
			int mid = s + ((e - s) >> 1);
			if (sums[mid] < target) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		if (sums[e] >= target) {
			return e;
		} else {
			return -1;
		}
	}
}
