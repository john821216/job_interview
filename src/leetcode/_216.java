package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _216 {
	public static void main(String[] args) {
		_216 a = new _216();
		a.execute();
	}

	public void execute() {
		combinationSum3(3, 9);
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		combinationSum3Helper(ll, l, 1, k, n);
		return ll;
	}

	public void combinationSum3Helper(List<List<Integer>> ll, List<Integer> l,
			int minI, int k, int n) {
		if (k > 0) {
			if (minI > 9)
				return;
			for (int i = minI; i <= 9; i++) {
				l.add(i);
				combinationSum3Helper(ll, l, i + 1, k - 1, n - i);
				l.remove(l.size() - 1);
			}
		} else if (k == 0) {
			if (n == 0) {
				List<Integer> c_l = new ArrayList<Integer>(l);
				ll.add(c_l);
				for (int i = 0; i < c_l.size(); i++) {
					System.out.print(c_l.get(i) + " ");
				}
				System.out.println();
			} else {
				return;
			}
		}
	}
}
