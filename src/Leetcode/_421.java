package Leetcode;

import java.util.HashSet;

public class _421 {
	public static void main(String[] args) {
		System.out.println((char)(3+'0'));
	}

	public int findMaximumXOR(int[] nums) {
		int max = 0;
		int mask = 0;
		for (int i = 31; i >= 0; i--) {
			HashSet<Integer> h = new HashSet<Integer>();
			mask = mask | (1 << i);
			for (int n : nums) {
				h.add(n & mask);
			}

			// for i bit choose 1 first, otherwise 0;
			int target = max | (1 << i);
			for (int n : h) {
				if (h.contains(n ^ target)) {
					max = target;
					break;
				}
			}
		}
		return max;
	}

	private class Tries {
		Tries[] children = new Tries[2];
	}

	// using tries
	public int findMaximumXOR2(int[] nums) {
		Tries root = new Tries();
		Tries cur;
		for (int n : nums) {
			cur = root;
			for (int i = 31; i >= 0; i--) {
				int curbits = (n >>> i) & 1;
				if (cur.children[curbits] == null) {
					cur.children[curbits] = new Tries();
					cur = cur.children[curbits];
				} else {
					cur = cur.children[curbits];
				}
			}
		}

		int max = 0;
		int curSum = 0;
		for (int n : nums) {
			cur = root;
			for (int i = 31; i >= 0; i--) {
				int curbit = (n >>> i) & 1;
				if (cur.children[curbit ^ 1] != null) {
					curSum += (1 << i);
					cur = cur.children[curbit ^ 1];
				} else {
					cur = cur.children[curbit ^ 0];
				}
			}
			max = Math.max(max, curSum);
		}
		return max;
	}

}
