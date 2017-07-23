package Leetcode;

import java.util.List;

public class _120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int minVal = Integer.MAX_VALUE;
		if(triangle.size() == 1){
		    return triangle.get(0).get(0);
		}
		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int leftVal;
				int rightVal;
				if (j - 1 < 0) {
					leftVal = Integer.MAX_VALUE;
				} else {
					leftVal = triangle.get(i - 1).get(j - 1);
				}

				if (j == triangle.get(i - 1).size()) {
					rightVal = Integer.MAX_VALUE;
				} else {
					rightVal = triangle.get(i - 1).get(j);
				}
				
				if(i != triangle.size()-1){
					int curVal = triangle.get(i).get(j);
					triangle.get(i).set(j, Math.min(leftVal, rightVal)+curVal);
					System.out.println(curVal);
				} else{
					int curVal = triangle.get(i).get(j);
					if(Math.min(leftVal, rightVal)+curVal < minVal){
						minVal = Math.min(leftVal, rightVal)+curVal;
					}
				}
			}
		}
		System.out.println(minVal);
		return minVal;
	}
}
