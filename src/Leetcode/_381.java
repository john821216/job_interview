package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class _381 {

	public static void main(String[] args) {
		_381 a = new _381();
		a.insert(1);
		System.out.println(nums);
		a.insert(1);
		System.out.println(nums);
		a.insert(2);
		System.out.println(nums);
		a.insert(1);
		System.out.println(nums);
		a.insert(2);
		System.out.println(nums);
		a.insert(2);
		System.out.println(nums);
		a.remove(1);
		System.out.println(nums);
		a.remove(2);
		System.out.println(nums);
		a.remove(2);
		System.out.println(nums);
		a.remove(2);
		System.out.println(nums);
		a.getRandom();
	}

	/** Initialize your data structure here. */
	static ArrayList<Integer> nums;
	HashMap<Integer, HashSet<Integer>> loc;

	public _381() {
		nums = new ArrayList<Integer>();
		loc = new HashMap<Integer, HashSet<Integer>>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean hasInserted = false;
		HashSet<Integer> h;
		if (loc.get(val) == null) {
			h = new HashSet<Integer>();
		} else {
			hasInserted = true;
			h = loc.get(val);
		}
		h.add(nums.size());
		loc.put(val, h);
		nums.add(val);
		return !hasInserted;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (loc.get(val) == null || loc.get(val).size() == 0) {
			return false;
		}

		HashSet<Integer> removeSet = loc.get(val);
		int removeEleLoc = removeSet.iterator().next();
		int lastEleLoc = nums.get(nums.size() - 1);
		if (removeEleLoc < nums.size() - 1) {
			nums.set(removeEleLoc, lastEleLoc);
			loc.get(val).remove(removeEleLoc);
			loc.get(lastEleLoc).add(removeEleLoc);
		}
		loc.get(lastEleLoc).remove(nums.size() - 1);
		nums.remove(nums.size() - 1);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return nums.get((int) (nums.size() * Math.random()));
	}
}
