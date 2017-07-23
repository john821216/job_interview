package Leetcode;

import java.util.HashMap;

public class _205 {
	public static void main(String[] args) {
		_205 a = new _205();
		a.execute();
	}

	public void execute() {
		System.out.println(isIsomorphic("aa", "aa"));
	}

	public boolean isIsomorphic(String s, String t) {
		int[] sArr = new int[256];
		int[] tArr = new int[256];
		int count = 1;

		for (int i = 0; i < s.length(); i++) {
			if (sArr[s.charAt(i)] != tArr[t.charAt(i)]) {
				return false;
			} else if (sArr[s.charAt(i)] == tArr[t.charAt(i)]) {
				if (sArr[s.charAt(i)] == 0) {
					sArr[s.charAt(i)] = count;
					tArr[t.charAt(i)] = count;
					count++;
				} else{
					continue;
				}
			}
		}
		return true;
	}
}
