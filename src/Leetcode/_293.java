package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _293 {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> l = new ArrayList<String>();
		for (int i = 2; i <= s.length(); i++) {
			String state = s.substring(i - 2, i);
			String newStr = "";
			if (state.equals("++")) {
				newStr = s.substring(0, i - 2) + "--" + s.substring(i);
				l.add(newStr);
			}
		}
		return l;
	}
}
