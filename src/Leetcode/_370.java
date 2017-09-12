package Leetcode;

public class _370 {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] arr = new int[length + 1];
		for (int[] u : updates) {
			int start = u[0];
			int end = u[1];
			int val = u[2];
			arr[start] += val;
			arr[end + 1] -= val;
		}

		int[] an = new int[length];
		 an[0] = arr[0];
		for (int i = 1; i < an.length; i++) {
			arr[i] += arr[i-1];
			an[i] = arr[i];
		}
		return an;
	}
}
