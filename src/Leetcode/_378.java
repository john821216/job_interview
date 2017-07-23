package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _378 {
	public static void main(String[] args) {
		_378 a = new _378();
		a.execute();
	}

	public void execute() {
		int[][] m = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest2(m, 2));
	}

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int[] compare = new int[n];
		int[] m_idx = new int[n];
		// ini
		for (int i = 0; i < n; i++) {
			compare[i] = matrix[i][0];
		}

		while (k != 0) {
			k--;
			int min = min(compare);
			System.out.println(matrix[min][m_idx[min]] + " " + k);
			if (k == 0) {
				return matrix[min][m_idx[min]];
			}
			m_idx[min]++;
			if (m_idx[min] < n) {
				compare[min] = matrix[min][m_idx[min]];
			} else {
				compare[min] = Integer.MAX_VALUE;
			}
		}
		return -1;

	}

	public int min(int[] nums) {
		int minVal = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (minVal > nums[i]) {
				minIdx = i;
				minVal = nums[i];
			}
		}
		return minIdx;
	}

	public int kthSmallest2(int[][] matrix, int k) {
		PriorityQueue<Tuple> p = new PriorityQueue<Tuple>(new Tuple());
		for (int i = 0; i < matrix.length; i++) {
			p.add(new Tuple(i, 0, matrix[i][0]));
		}
		
		for(int i = 0 ; i < k-1 ; i++){
			Tuple t = p.poll();
			if(t.y == matrix[0].length-1) continue;
			p.add(new Tuple(t.x, t.y+1, matrix[t.x][t.y+1]));
		}
		return p.poll().val;
	}

	private class Tuple implements Comparator<Tuple> {
		int x;
		int y;
		int val;
		public Tuple(){
			
		}
		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compare(Tuple o1, Tuple o2) {
			return o1.val - o2.val;
		}
	}
}
