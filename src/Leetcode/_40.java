package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[10, 1, 2, 7, 6, 1, 5] target 8
public class _40 {
	public static void main(String[] args) {
		_40 a = new _40();
		a.execute();
	}

	public void execute() {
		int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
		combinationSum2(arr, 8);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		Arrays.sort(candidates);
		
		
		
		findSumHelper(ll, l, candidates, 0, target);
		return ll;
	}

	public void findSumHelper(List<List<Integer>> ll, List<Integer> l,
			int[] can, int start, int target) {
		if (target < 0)
			return;
		if (target == 0) {
			ll.add(new ArrayList<Integer>(l));
			// for testing

			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i) + " ");
			}
			System.out.println();

		} else {
			for (int i = start; i < can.length; i++) {
				//Good way to write
				//if (i > cur && cand[i] == cand[i-1]) continue;
				
				l.add(can[i]);
				findSumHelper(ll, l, can, i + 1, target - can[i]);
				l.remove(l.size() - 1);
				while(i < can.length - 1  && can[i+1] == can[i]){
					i++;
				}
			}
		}
	}
}
