package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _496 {
	public static void main(String[] args){
		_496 a = new _496();
		a.execute();
	}
	
	public void execute(){
		int[] find ={4,1,2};
		int[] n = {1,3,4,2};
		nextGreaterElement(find,n);
	}
	
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (s.isEmpty()) {
				s.add(i);
			} else {
				int aboutToPush = nums[i];
				while (!s.isEmpty() && nums[s.peek()] < aboutToPush) {
					h.put(nums[s.pop()], aboutToPush);
				}
				s.add(i);
			}
		}

		int[] an = new int[findNums.length];
		Arrays.fill(an, -1);
		for (int i = 0; i < findNums.length; i++) {
			if(h.containsKey(findNums[i])){
				an[i] = h.get(findNums[i]);
			} 
			System.out.print(an[i]+" ");
		}
		return an;
	}
}
