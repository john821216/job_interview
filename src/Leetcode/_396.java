package Leetcode;

public class _396 {
	public int maxRotateFunction(int[] A) {
		int sum = 0;
		int f = 0;
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			f += i * A[i];
		}
		max = f;
		for (int i = A.length - 1; i >= 1; i--) {
			f = f + sum - A.length * A[i];
			max = Math.max(max, f);
		}
		return max;
	}
}
