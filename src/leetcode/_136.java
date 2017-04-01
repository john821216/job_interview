package leetcode;

import java.util.HashMap;

public class _136 {
	public static void main(String[] args) {
		_136 a = new _136();
		a.execute();
	}

	public void execute() {
		int[] arr = { 1, 2, 2, 4, 5, 1, 5 };
		System.out.println(singleNumber(arr));
	}

	// A^(B^C) = (A^B)^C
	public int singleNumber(int[] A) {
		int x = 0;
		for (int a : A) {
			x = x ^ a;
		}
		return x;
	}

}
