package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _313 {
	public static void main(String[] args) {
		_313 a = new _313();
		a.execute();
	}

	public void execute() {
		int[] arr = { 2, 7, 13, 19 };
		System.out.println(nthSuperUglyNumber2(14, arr));
	}

	// O(K*N)
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			int minIdx = 0;
			int min = primes[minIdx] * ugly[idx[minIdx]];
			for (int j = 1; j < primes.length; j++) {
				if (min > primes[j] * ugly[idx[j]]) {
					min = primes[j] * ugly[idx[j]];
					minIdx = j;
				}
			}

			for (int j = 0; j < primes.length; j++) {
				if (min == primes[j] * ugly[idx[j]]) {
					idx[j]++;
				}
			}
			ugly[i] = min;
		}

		return ugly[n - 1];
	}

	// O(logk *N)
	public int nthSuperUglyNumber2(int n, int[] primes) {
		PriorityQueue<Num> pq = new PriorityQueue<Num>(new Num());
		int[] ugly = new int[n];
		ugly[0] = 1;
		Num[] ns = new Num[primes.length];
		for(int i = 0 ; i < primes.length ; i++){
			ns[i] = new Num();
			ns[i].n = primes[i];
			ns[i].idx = 0;
			ns[i].p = primes[i];
			pq.add(ns[i]);
		}
		
		for(int i = 1 ; i < n ; i++){
			 Num poll = pq.poll();
			 ugly[i] = poll.n;
			 while(!pq.isEmpty() && (pq.peek().n == poll.n)){
				 Num p = pq.poll();
				 Num newP = new Num();
				 newP.idx = p.idx + 1;
				 newP.p = p.p;
				 newP.n = ugly[newP.idx] * p.p;
				 pq.add(newP);
			 }
			 
			 Num newAdd = new Num();
			 newAdd.idx= poll.idx + 1;
			 newAdd.p = poll.p;
			 newAdd.n = ugly[newAdd.idx] * poll.p;
			 pq.add(newAdd);
		}
		return ugly[n-1];
	}

	private class Num implements Comparator<Num> {
		int n;
		int idx;
		int p;
		@Override
		public int compare(Num o1, Num o2) {
			return o1.n - o2.n;
		}
	}
}
