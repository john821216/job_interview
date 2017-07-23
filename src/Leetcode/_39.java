package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {
	public static void main(String[] args) {
		_39 a = new _39();
		a.execute();
	}

	public void execute() {
		int[] arr = { 8, 3, 6, 7 };
		combinationSum(arr, 14);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		findCombination(ll, l, candidates, 0, 0, target);
		return ll;
	}

	public void findCombination(List<List<Integer>> ll, List<Integer> l,
			int[] arr, int start, int sum, int target) {
		if (sum == target) {
			ll.add(new ArrayList<Integer>(l));
			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i) + " ");
			}
			System.out.println();
			return;
		} else if (sum > target) {
			return;
		} else {
			for (int i = start; i < arr.length; i++) {
				l.add(arr[i]);
				findCombination(ll, l, arr, i, sum + arr[i], target);
				l.remove(l.size()-1);
			}
		}	
	}
}
