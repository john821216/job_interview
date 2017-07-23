package Leetcode;

import java.util.HashMap;

public class _1 {
	 public int[] twoSum(int[] numbers, int target) {
		 int[] an = new int[2];
		 HashMap<Integer ,Integer> m = new HashMap<Integer, Integer>();
		 
		 for(int i = 0 ; i < numbers.length ; i++){
			 if(m.containsKey((target-numbers[i]))){
				 an[0] = i;
				 an[1] = m.get(target-numbers[i]);
				 break;
			 } else{
				 m.put(numbers[i], i);
			 }
		 }
		 return an;
	 }
}
