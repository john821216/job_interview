package Leetcode;

public class _330 {

	public static void main(String[] args) {
		_330 a = new _330();
		a.execute();
	}

	public void execute() {
		System.out.println(minPatches(new int[] { 1, 5, 10 }, 20));
	}

	public int minPatches(int[] nums, int n) {
		long miss = 1;
		int idx = 0;
		int added = 0;
		// range [0,miss)
		while (miss <= n) {
			if (idx < nums.length && nums[idx] <= miss) {
				miss += nums[idx];
				idx++;
			} else {
				miss += miss;
				added++;
			}
		}
		return added;
	}
}
