package Leetcode;

import java.util.LinkedList;

public class _484 {
	public static void main(String[] args) {
		_484 a = new _484();
		a.execute();
	}

	public void execute() {
		System.out.println(findPermutation("DI"));
	}

	public int[] findPermutation(String s) {
		int[] an = new int[s.length() + 1];
		int cur = 1;
		int Dcount = 0;
		int anIdx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I') {
				if (Dcount != 0) {
					for (int j = cur + Dcount; j >= cur; j--) {
						an[anIdx++] = j;
					}
					cur = cur + Dcount + 1;
					Dcount = 0;
				} else {
					an[anIdx++] = cur++;
				}
			} else {
				Dcount++;
			}
		}

		if (Dcount != 0) {
			for (int j = cur + Dcount; j >= cur; j--) {
				an[anIdx++] = j;
			}
			Dcount = 0;
		}

		if (anIdx != an.length) {
			an[anIdx] = cur;
		}

		for (int i : an) {
			System.out.print(i + " ");
		}
		System.out.println();
		return an;
	}
}
