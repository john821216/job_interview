package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _47 {
	public static void main(String[] args) {
		_47 a = new _47();
		a.execute();
	}

	public void execute() {
		int[] arr = { 1, 1, 2, 2 };
		permute(arr);
	}

	public List<List<Integer>> permute(int[] nums) {
		Set<List<Integer>> ll = new HashSet<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		permuteHelper2(ll, l, nums, 0);

		ArrayList<List<Integer>> an = new ArrayList<List<Integer>>(ll);
		for (int i = 0; i < an.size(); i++) {
			System.out.println(an.get(i));
		}
		return an;
	}

	// hashset
	public void permuteHelper(Set<List<Integer>> ll, List<Integer> l,
			int[] nums, int i) {

		// stop
		if (i == nums.length) {
			ll.add(new ArrayList<Integer>(l));
			return;
		}

		int j = i;
		for (int a = j; a < nums.length; a++) {
			// swap
			int temp = nums[i];
			nums[i] = nums[a];
			nums[a] = temp;
			l.add(nums[i]);
			permuteHelper(ll, l, nums, i + 1);

			// swap
			temp = nums[i];
			nums[i] = nums[a];
			nums[a] = temp;
			l.remove(l.size() - 1);
		}
	}

	// contain duplicate
	public void permuteHelper2(Set<List<Integer>> ll, List<Integer> l,
			int[] nums, int i) {

		// stop
		if (i == nums.length) {
			ll.add(new ArrayList<Integer>(l));
			return;
		}

		int j = i;
		for (int a = j; a < nums.length; a++) {
			if (!containDuplicate(nums, i, a, nums[a])) {
				// swap
				int temp = nums[i];
				nums[i] = nums[a];
				nums[a] = temp;
				l.add(nums[i]);
				permuteHelper(ll, l, nums, i + 1);

				// swap
				temp = nums[i];
				nums[i] = nums[a];
				nums[a] = temp;
				l.remove(l.size() - 1);
			}
		}
	}

	public boolean containDuplicate(int[] nums, int start, int end, int target) {
		for (int i = start; i < end; i++) {
			if (nums[i] == target) {
				return true;
			}
		}
		return false;
	}
}
