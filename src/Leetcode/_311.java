package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _311 {
	public int[][] multiply(int[][] A, int[][] B) {
		List<Integer>[] idx = new ArrayList[A.length];
		int[][] result = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			idx[i] = new ArrayList<Integer>();
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] != 0) {
					idx[i].add(j);
					idx[i].add(A[i][j]);
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			List<Integer> curIdx = idx[i];
			for (int j = 0; j < curIdx.size(); j+=2) {
				int colA = idx[i].get(j);
				int valA = idx[i].get(j+1);
				for (int k = 0; k < B[0].length; k++) {
					int val = B[colA][k] * valA;
					result[i][k] += val;
				}
			}
		}
		return result;
	}
}
