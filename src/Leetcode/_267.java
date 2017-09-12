package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _267 {
	public static void main(String[] args) {
		_267 a = new _267();
		a.execute();
	}

	public void execute() {
		System.out.println(generatePalindromes("aaaabbbb"));
	}

	public List<String> generatePalindromes(String s) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (char c : s.toCharArray()) {
			int idx = c - 'a';
			if (!h.containsKey(idx)) {
				h.put(idx, 1);
			} else {
				h.put(idx, h.get(idx) + 1);
			}
		}
		int oddCount = 0;
		String oddVal = "";
		StringBuilder rest = new StringBuilder();
		List<String> an = new ArrayList<String>();
		for (int i : h.keySet()) {
			if (h.get(i) % 2 == 1) {
				oddCount++;
				oddVal = (char) (i + 'a') + "";
			}
			for (int j = 0; j < h.get(i) / 2; j++) {
				rest.append((char) (i + 'a'));
			}
		}
		
		
		if (s.length() % 2 == 1) {	
			if (oddCount != 1) {
				return an;
			} else {
				permutation(an, rest.toString(), oddVal);
			}
		} else {
			if (oddCount > 0) {
				return an;
			} else {
				permutation(an, rest.toString(), oddVal);

			}
		}
		return an;
	}

	public void permutation(List<String> l, String curS, String oddVal) {
		HashSet<String> appear;
		Queue<String> q = new LinkedList<String>();
		StringBuilder sb;
		q.add(curS);
		int lv = 0;
		while (!q.isEmpty()) {
			if(lv== curS.length()) {
				while(!q.isEmpty()) {
					String pop = q.poll();
					l.add(pop + oddVal + new StringBuilder(pop).reverse().toString());					
				}		
				break;
			}
			
			int size = q.size();
			appear = new HashSet<String>();
			for (int s = 0; s < size; s++) {		
				String poll = q.poll();
				sb = new StringBuilder(poll);
				for (int i = lv; i < sb.length(); i++) {
					char temp = sb.charAt(i);
					sb.setCharAt(i, sb.charAt(lv));
					sb.setCharAt(lv, temp);
					
					if (!appear.contains(sb.toString())) {
						appear.add(sb.toString());
						q.add(sb.toString());
					}
					sb = new StringBuilder(poll);
				}
				System.out.println(q);
			}
			lv++;
		}
	}
}
