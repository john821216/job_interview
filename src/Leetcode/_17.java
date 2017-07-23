package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _17 {
	public static void main(String[] args) {
		_17 a = new _17();
		a.execute();
	}

	public void execute() {
		System.out.println(letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
		String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		List<String> comb = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return comb;
		}
		comb.add("");

		for (int i = 0; i < digits.length(); i++) {
			List<String> cop = comb;
			comb = new ArrayList<String>();
			for (int j = 0; j < cop.size(); j++) {
				for (int k = 0; k < map[digits.charAt(i)-'0'].length(); k++) {
					comb.add(cop.get(j) + "" + map[digits.charAt(i)-'0'].charAt(k));
				}
			}
		}
		return comb;
	}
}
