package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _219 {
	public static void main(String[] args) {
		_219 a = new _219();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,2,1,3,5};
		System.out.println(containsNearbyDuplicate(arr,2));

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i = 0 ; i < nums.length ; i++){
			if(i <= k){
				if(s.contains(nums[i])) return true;
				s.add(nums[i]);
			} else{
				s.remove(nums[i-k-1]);
				if(s.contains(nums[i])) return true;
				s.add(nums[i]);
			}
		}
		return false;
		
	}
}
