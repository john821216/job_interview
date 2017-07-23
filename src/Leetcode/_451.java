package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class _451 {
	// keyset vs entryset
	// http://www.java67.com/2016/05/keyset-vs-entryset-vs-values-in-java-map-example.html
	// bucket sort
	public String frequencySort(String s) {
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char curC = s.charAt(i);
			if (h.get(curC) == null) {
				h.put(curC, 1);
			} else {
				h.put(curC, h.get(curC) + 1);
			}
		}

		List<Character>[] l = new List[s.length() + 1];
		for (char c : h.keySet()) {
			int freq = h.get(c);
			if (l[freq] == null) {
				l[freq] = new ArrayList<Character>();
				l[freq].add(c);
			} else {
				l[freq].add(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = l.length - 1; i >= 0; i--) {
			if (l[i] != null) {
				for (int j = 0; j < l[i].size(); j++) {
					for (int k = 0; k < i; k++) {
						sb.append(l[i].get(j));
					}
				}
			}
		}
		return sb.toString();
	}

	// priority queue
	public String frequencySort2(String s) {
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char curC = s.charAt(i);
			if (h.get(curC) == null) {
				h.put(curC, 1);
			} else {
				h.put(curC, h.get(curC) + 1);
			}
		}

		// // traversing Map using entrySet() method
		// Set<Map.Entry<Character, Integer>> entries = h.entrySet();
		// for(Map.Entry<String, Integer> entry : entries){
		// String key = entry.getKey();
		// Integer value = entry.getValue();
		// System.out.printf("key: %s, value: %d %n", key, value);
		// }

		PriorityQueue<Map.Entry<Character, Integer>> p = new PriorityQueue<Map.Entry<Character, Integer>>(
				new Comparator<Map.Entry<Character, Integer>>(){

					@Override
					public int compare(Map.Entry<Character, Integer> o1,
							Map.Entry<Character, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}
					
				});
		
		//this way is ok
		//p.addAll(h.entrySet());

		// or this way
		Set<Map.Entry<Character, Integer>> entries = h.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			p.add(entry);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!p.isEmpty()){
			Map.Entry<Character, Integer> e = p.poll();
			for(int i = 0 ; i < e.getValue() ; i++){
				sb.append(e.getKey());
			}
		}
		return sb.toString();
		
	}
}
