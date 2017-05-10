package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _392 {
	public static void main(String[] args){
		_392 a = new _392();
		a.execute();
	}
	
	public void execute(){
		isSubsequence2("acb","ahbgdca");
	}
	
	public boolean isSubsequence(String s, String t) {
		int indexS = 0;
		int indexT = 0;
		while (indexS < s.length() && indexT < t.length()) {
			if (s.charAt(indexS) == t.charAt(indexT)) {
				indexS++;
			}
			indexT++;
		}
		return indexS == s.length();
	}

	public boolean isSubsequence2(String s, String t) {
		Map<Character, List<Integer>> m = new HashMap<Character, List<Integer>>();

		for (int i = 0; i < t.length(); i++) {
			System.out.println(t.charAt(i));
			if (!m.containsKey(t.charAt(i))) {
			    List<Integer> l = new ArrayList<Integer>();
			    l.add(i);
				System.out.println(t.charAt(i)+" " + i);
				m.put(t.charAt(i),l);
			} else {
				List<Integer> newL = m.get(t.charAt(i));
				newL.add(i);
				m.put(t.charAt(i), newL);
			}
		}

		int prev = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			List<Integer> l = m.get(c);
			System.out.println(l);
			if(l == null) return false;
			prev = binarySearch(prev,l,0,l.size()-1);
			System.out.println(prev);

			if(prev == -1) return false;
			prev++;
		}
		return true;
	}

	public int binarySearch(int pre, List<Integer> l, int start, int end) {
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (l.get(mid) < pre) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (start == l.size()) {
			return -1;
		} else {
			return l.get(start);
		}
	}
}
