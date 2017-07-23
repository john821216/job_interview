package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class _380 {
	ArrayList<Integer> n;
	HashMap<Integer, Integer> locs;
	
	/** Initialize your data structure here. */
	public _380() {
		n = new ArrayList<Integer>();
		locs = new HashMap<Integer, Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (locs.containsKey(val)){
			return false;
		} 
		locs.put(val, n.size());
		n.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if(!locs.containsKey(val)){
			return false;
		}
		int l = locs.get(val);
		
		//not last one
		if(l < n.size()-1){
			//last one
			int last = n.get(n.size()-1);
			n.set(l, last);
			locs.put(last, l);
		}
		n.remove(n.size()-1);
		locs.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return n.get((int)(Math.random()*n.size()));
	}
}
