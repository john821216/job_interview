package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _241 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> cur = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-'
					|| input.charAt(i) == '*') {
				List<Integer> l1 = diffWaysToCompute(input.substring(0,i));
				List<Integer> l2 = diffWaysToCompute(input.substring(i+1));
				for(int j = 0 ; j  < l1.size() ; j++){
					for(int k = 0 ; k < l2.size() ; k++){
						if(input.charAt(i) == '+'){
							cur.add(l1.get(j) + l2.get(k));
						} else if(input.charAt(i) == '-'){
							cur.add(l1.get(j) - l2.get(k));
						} else{
							cur.add(l1.get(j) * l2.get(k));
						}
					}
				}
			}
		}
		if(cur.size() == 0){
			cur.add(Integer.parseInt(input));
		}
		return cur;
	}
}
