package Leetcode;

public class _410 {
	public static void main(String args[]) {
		_410 a = new _410();
		a.execute();
	}

	public void execute() {
		System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
	}

	public int splitArray(int[] nums, int m) {
		int min = 0;
		int max = 0;
		for (int i : nums) {
			min = Math.max(i, min);
			max += i;
		}

		while (min != max) {
			int mid = (max - min) / 2 + min;
			if (valid(nums, m, mid)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	public boolean valid(int[] nums, int m, int val) {
		int count = 0;
		for (int i : nums) {
			count += i;
			if (count > val) {
				count = i;
				m--;
				if (m == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
