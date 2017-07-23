package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class _217 {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for(int num : nums){
			if(s.contains(num)){
				return true;
			}
			s.add(num);
		}
		return false;
	}
}
