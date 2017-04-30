package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _60 {
	public static void main(String[] args) {
		// getPermutation(3,3);
		_60 a = new _60();
		a.execute();
	}

	public void execute() {
		System.out.println(getPermutation(3, 3));
	}

	public String getPermutation(int n, int k) {
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int i = 1; i <= n; i++) {
			f[i] = f[i - 1] * i;
		}

		k--;

		List<Integer> l = new ArrayList<Integer>();
		String an = "";
		for (int i = 1; i <= n; i++) {
			l.add(i);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(k + " " + i);
			int index = k / f[n - i - 1];
			an += l.get(index) + "";
			l.remove(index);
			k = k- k / f[n - i - 1] * f[n - i - 1];
		}
		return an;
	}
}
