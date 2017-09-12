package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _254 {
	public static void main(String[] args) {
		_254 a = new _254();
		a.execute();
	}
	
	public void execute() {
		getFactors(12);
	}
	
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		if(n==1) {
			return ll;
		}
		List<Integer> l = new ArrayList<Integer>();
		getFactorsHelper(ll, l, 2, n, n);
		return ll;
	}

	public void getFactorsHelper(List<List<Integer>> ll, List<Integer> l, int from, int to, int n) {
		if (n == 1) {
			if (l.size() != 1) {
				ll.add(new ArrayList<Integer>(l));
				System.out.println(l+"AA");
			}
		}
		for (int i = from; i <= n; i++) {
			if (n % i == 0) {
				l.add(i);
				getFactorsHelper(ll, l, i, to / i, n / i);
				l.remove(l.size()-1);
			}
		}
	}
}
