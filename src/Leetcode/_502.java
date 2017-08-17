package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _502 {

	public static void main(String[] args) {
		_502 a = new _502();
		a.execute();
	}

	public void execute() {
		findMaximizedCapital(1, 2, new int[] { 1, 2, 3 }, new int[] { 1, 1, 2 });
	}

	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Proj[] pr = new Proj[Profits.length];
		for (int i = 0; i < pr.length; i++) {
			pr[i] = new Proj();
			pr[i].profit = Profits[i];
			pr[i].capital = Capital[i];
		}

		Arrays.sort(pr, new capitalComparator());
		int curW = W;
		int idx = 0;

		PriorityQueue<Proj> p = new PriorityQueue<Proj>(new profitComparator());

		while (k > 0) {
			while (idx < pr.length) {
				if (pr[idx].capital <= curW) {
					p.add(pr[idx]);
					idx++;
				} else {
					break;
				}
			}
			if (p.isEmpty()) {
				break;
			} else {
				curW += p.poll().profit;
				k--;
			}
		}
		return curW;

	}

	private class Proj {
		int profit;
		int capital;
	}

	private class capitalComparator implements Comparator<Proj> {

		@Override
		public int compare(Proj o1, Proj o2) {
			return o1.capital - o2.capital;
		}

	}

	private class profitComparator implements Comparator<Proj> {

		@Override
		public int compare(Proj o1, Proj o2) {
			return o2.profit - o1.profit;
		}

	}
}
