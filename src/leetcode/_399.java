package Leetcode;

import java.util.HashMap;


public class _399 {
	public double[] calcEquation(String[][] equations, double[] values,
			String[][] queries) {
		HashMap<String, Double> h = new HashMap<String,Double>();
		HashMap<String, String> fromEnd = new HashMap<String,String>();
		for(int i = 0 ; i < values.length ; i++){
			String first = equations[i][0];
			String second = equations[i][1];
			fromEnd.put(first, second);
		}
		int next;
		int cur;
		for(int i = 0 ; i < values.length ; i++){
			if(i==0){
				h.put(equations[i][0], values[i]);
				h.put(equations[i][1], 1.0);
			}
			String first = equations[i][0];
			String second = equations[i][1];
			if(!h.containsKey(first) && !h.containsKey(second)){
				h.put(first, values[i]);
				h.put(second, 1.0);
				continue;
			}
			
			if(h.containsKey(first)){
				h.put(second, h.get(first)/values[i]);
				continue;
			}
			
			if(h.containsKey(second)){
				h.put(first, h.get(second)*values[i]);
				continue;
			}
		}
		double[] an = new double[queries.length];
		for(int i = 0 ; i < queries.length ; i++){
			if(h.get(queries[i][0]) == null || h.get(queries[i][1]) == null){
				an[i] = -1;
				continue;
			}
			
			an[i] = h.get(queries[i][0]) / h.get(queries[i][1]);
		}
		return an;
	}
}
