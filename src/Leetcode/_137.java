package Leetcode;

public class _137 {
	public int singleNumber(int[] nums) {
		int a = 0;
		int b = 0;
		for (int n : nums) {
			int tempA = a;
			a = (a & ~b & ~n) | (~a & b & n);
			b = (~tempA & b & ~n) | (~tempA & ~b & n);
		}

		return a | b;
	}
}
