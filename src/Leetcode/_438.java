package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _438 {
	public static void main(String[] args) {
		_438 a = new _438();
		a.execute();
	}

	public void execute() {
		findAnagrams("cbaebabacd", "abc");
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> l = new ArrayList<Integer>();
		if (s == null || p == null || s.length() == 0 || p.length() == 0
				|| s.length() < p.length()) {
			return l;
		}

		int[] alphabet = new int[256];

		for (int i = 0; i < p.length(); i++) {
			alphabet[p.charAt(i)]++;
		}

		int i = 0;
		int j = p.length() - 1;
		int count = 0;
		for (int a = i; a <= j; a++) {
			if (alphabet[s.charAt(a)] >= 1) {
				count++;
			}
			alphabet[s.charAt(a)]--;
		}

		if (count == p.length()) {
			l.add(0);
			System.out.println(0);
		}

		j++;
		while (j < s.length()) {
			if(alphabet[s.charAt(i)] >= 0) count--;
			alphabet[s.charAt(i)]++;
			i++;
			
			if(alphabet[s.charAt(j)] >= 1) count++;
			alphabet[s.charAt(j)]--;
			
			if (count == p.length()) {
				l.add(i);
			}
			j++;
		}
		return l;
	}
}
